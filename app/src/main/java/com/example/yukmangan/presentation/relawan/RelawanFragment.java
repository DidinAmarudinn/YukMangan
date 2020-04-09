package com.example.yukmangan.presentation.relawan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yukmangan.R;
import com.example.yukmangan.network.model.relawan.Datum;
import com.example.yukmangan.network.model.relawan.Relawan;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelawanFragment extends Fragment implements RelawanView {

    private RelawanPresenter presenter;
    private TextView nama, alamat;

    public RelawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relawan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new RelawanPresenter();
        presenter.getDataRelawanById("52");
        nama = view.findViewById(R.id.tv_name_relawan_dashboard);

    }

    @Override
    public void getDataRelawanById(Relawan relawan) {
        Log.e("ERROR",relawan.getData().get(0).getNamaLengkap());
        nama.setText(relawan.getData().get(0).getNamaLengkap());

    }

    @Override
    public void onFailure(Throwable error) {
        Log.e(RelawanFragment.class.getSimpleName(),error.getLocalizedMessage());

    }
}
