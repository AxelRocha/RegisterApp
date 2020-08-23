package com.example.registerapp.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.registerapp.R;
import com.example.registerapp.model.PersonalData;

public class DeleteDialogFragment extends DialogFragment {

    private RegisterListContract.DeleteListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final PersonalData personalData = (PersonalData) getArguments().getSerializable("personalDataObj");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Você tem certeza em deletar " + personalData.getName() + "?");

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.setConfirm(true, personalData);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.setConfirm(false, personalData);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (RegisterListContract.DeleteListener) context;
    }

}
