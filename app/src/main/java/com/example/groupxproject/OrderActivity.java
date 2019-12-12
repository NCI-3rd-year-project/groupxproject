package com.example.groupxproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class OrderActivity extends AppCompatActivity {

    private EditText mPostName;
    private EditText mPostPhone;
    private EditText mPostAddress;
    private EditText mPostMed;
    private Button mSubmitBtn2;
    private Uri mImageUri2 = null;
    private ImageButton  mSelectImage;

    private static final int GALLERY_REQUEST = 1;

    private StorageReference mStorage;

    private DatabaseReference mDatabase;


    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);



        mPostName = (EditText) findViewById(R.id.nameField);
        mPostPhone = (EditText) findViewById(R.id.phoneField);
        mPostAddress = (EditText) findViewById(R.id.addressField);
        mPostMed = (EditText) findViewById(R.id.medField);
        mSelectImage = (ImageButton) findViewById(R.id.imageSelect);


        mSubmitBtn2 = (Button) findViewById(R.id.submitBtn2);
        mStorage = FirebaseStorage.getInstance().getReference();
        mProgress = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Order");




        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);

            }
        });


        mSubmitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPosting();

            }
        });

    }

    private void startPosting() {

        mProgress.setMessage("Order is in process...");
        mProgress.show();

        final String name_val = mPostName.getText().toString().trim();
        final String phone_val = mPostPhone.getText().toString().trim();
        final String address_val = mPostAddress.getText().toString().trim();
        final String med_val = mPostMed.getText().toString().trim();

        if(!TextUtils.isEmpty(name_val) && !TextUtils.isEmpty(phone_val) && !TextUtils.isEmpty(address_val) && !TextUtils.isEmpty(med_val) ){

            StorageReference filepath = mStorage.child("Post_Images").child(mImageUri2.getLastPathSegment());


            filepath.putFile(mImageUri2).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                    String downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();

                    DatabaseReference newPost = mDatabase.push();

                    newPost.child("name").setValue(name_val);
                    newPost.child("phone").setValue(phone_val);
                    newPost.child("address").setValue(address_val);
                    newPost.child("Medicine_Order").setValue(med_val);
                    newPost.child("image").setValue(downloadUrl.toString());



                    mProgress.dismiss();

                    startActivity(new Intent(OrderActivity.this, MainActivity.class));

                }
            });


        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){

            mImageUri2 = data.getData();

            mSelectImage.setImageURI(mImageUri2);


        }

    }
}
