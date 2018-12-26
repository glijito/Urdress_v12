package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.R;

public class FragmentPerfil extends Fragment{

    private DataListener callback;
    private Button btnDesliza;
    private ImageButton menuContextual;
    private GestureDetector gestureDetector;

    public FragmentPerfil() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        btnDesliza = (Button) view.findViewById(R.id.desliza);
        menuContextual = (ImageButton) view.findViewById(R.id.opciones);
        final GestureDetector gesture = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getY()-e2.getY()<-350){
                    callback.sendDataPer();
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
        btnDesliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendDataPer();
            }
        });
        registerForContextMenu(menuContextual);

        menuContextual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.showContextMenu();
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(getActivity());
        //inflater.inflate(R.menu.menu_contextual_perfil, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       // switch (item.getItemId()){
            /*case R.id.email:
                Toast.makeText(getActivity(), "Email", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nummobil:
                Toast.makeText(getActivity(), "Numero Mobil", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.bancarios:
                Toast.makeText(getActivity(), "Datos Bancarios", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.formapago:
                Toast.makeText(getActivity(), "Forma de Pago", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eliminar:
                Toast.makeText(getActivity(), "Eliminar", Toast.LENGTH_SHORT).show();
                return true;
            default:*/
                return super.onContextItemSelected(item);
     //   }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (DataListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " should implement DataListener");
        }
    }

    public interface DataListener {
        void sendDataPer();
    }

}
