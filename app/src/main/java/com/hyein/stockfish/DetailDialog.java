package com.hyein.stockfish;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyein.stockfish.network.HttpClient;

/**
 * Created by nolgong-hyein on 2016. 12. 30..
 */

public class DetailDialog extends DialogFragment {
    private static final String FILE_NAME = "fileName";

    private String fileName;
    View view;
    public DetailDialog(){}

    public static DetailDialog newInstance(String fileName){
        DetailDialog dialog = new DetailDialog();
        Bundle args = new Bundle();
        args.putString(FILE_NAME, fileName);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            fileName = getArguments().getString("fileName");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.dialog_detail,container);
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        ImageView imageView = (ImageView)view.findViewById(R.id.dialogDetailImageView);
        Glide.with(getActivity()).load(HttpClient.getAddress()+"/static/images/"+fileName)
                .into(imageView);

        return view;
    }



    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        dismiss();
    }

}
