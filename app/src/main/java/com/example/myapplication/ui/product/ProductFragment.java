package com.example.myapplication.ui.product;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.PdfDatabase;
import com.example.myapplication.R;

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    DatabaseHelper myDb;
    EditText editProductName, editDescription, editPrice, editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                new ViewModelProvider(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        myDb = new DatabaseHelper(getActivity());
        editProductName = root.findViewById(R.id.editTextTextPersonName3);
        editDescription = root.findViewById(R.id.editTextTextPersonName4);
        editPrice = root.findViewById(R.id.editTextTextPersonName5);
        editTextId = root.findViewById(R.id.editTextTextPersonName6);
        btnAddData = root.findViewById(R.id.button4);
        btnviewAll = root.findViewById(R.id.button7);
        btnviewUpdate = root.findViewById(R.id.button8);
        final Button btnNext = (Button) root.findViewById(R.id.button2);
        btnDelete= root.findViewById(R.id.button9);
        Intent intent = new Intent(getActivity(), PdfDatabase.class);
        btnNext.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Proceed to generate PDF", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
        return root;
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText(), toString());
                        if(deletedRows>0)
                            Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "Data not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editProductName.getText().toString(),
                                editDescription.getText().toString(), editPrice.getText().toString() );
                        if(isUpdate)
                            Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "Data not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                v -> {
                    boolean isInserted = myDb.insertData(editProductName.getText().toString(), editDescription.getText().toString(),
                            editPrice.getText().toString());

                    if (isInserted)
                        Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
                }
        );
    }

    public void viewAll(){
        btnviewAll.setOnClickListener(
                v -> {
                    Cursor res = myDb.getAllData();
                    if(res.getCount() == 0){
                        //show message
                        showMessage("Error", "No Data");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("ID:").append(res.getString(0)).append("\n");
                        buffer.append("Name:").append(res.getString(1)).append("\n");
                        buffer.append("Description:").append(res.getString(2)).append("\n");
                        buffer.append("Price:").append(res.getString(3)).append("\n\n");
                    }
                    //Show all data
                    showMessage("data", buffer.toString());
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        return true;
//    }

}