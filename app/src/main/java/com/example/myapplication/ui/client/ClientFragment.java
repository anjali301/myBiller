package com.example.myapplication.ui.client;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class ClientFragment extends Fragment {
    EditText name, email, phone, address;
    ImageView mImageView;
    Button mChooseBtn;
    Button clientBtn;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    private ClientViewModel clientViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientViewModel =
                new ViewModelProvider(this).get(ClientViewModel.class);
        View root = inflater.inflate(R.layout.fragment_client, container, false);
        name = root.findViewById(R.id.editTextTextPersonName);
        email = root.findViewById(R.id.editTextTextEmailAddress);
        phone = root.findViewById(R.id.editTextPhone);
        address = root.findViewById(R.id.editTextTextMultiLine);
        mImageView = root.findViewById(R.id.image_view);
        mChooseBtn = root.findViewById(R.id.image_btn);
        clientBtn = root.findViewById(R.id.btnClient);
        mChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {
                        pickImageFromGallery();
                    }
            }
        });
        clientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() ||
                    email.getText().toString().isEmpty() ||
                    phone.getText().toString().isEmpty() ||
                    address.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter all details", Toast.LENGTH_SHORT).show();
                }
                else if (phone.getText().toString().length() != 10){
                    Toast.makeText(getActivity(), "Please enter 10 digit mobile number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Client added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(getActivity(), "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestcode == IMAGE_PICK_CODE) {
//            mImageView.setImageURI(data.getData());
//        }
        if(resultCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_CODE) {
                Uri contentURI = data.getData();
                try {
                    mImageView.setImageURI(contentURI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}