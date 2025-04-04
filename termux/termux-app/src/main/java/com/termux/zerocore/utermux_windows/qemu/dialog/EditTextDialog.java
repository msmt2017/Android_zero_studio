package com.termux.zerocore.utermux_windows.qemu.dialog;

import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blockchain.ub.util.custom.dialog.BaseDialogCentre;
import com.example.xh_lib.utils.UUtils;
import com.termux.R;

import java.io.File;



/**
 * @author ZEL
 * @create By ZEL on 2020/10/15 17:29
 **/
public class EditTextDialog extends BaseDialogCentre {

    private TextView cancel;
    private TextView commit;
    private TextView start;
    private TextView commit_file;
    private ImageView close_img;
    private String id;
    private EditText edit_text;
    public EditTextDialog(@NonNull Context context) {
        super(context);
        this.id = id;
    }

    public EditTextDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public void initViewDialog(View mView) {

        cancel = mView.findViewById(R.id.cancel);
        close_img = mView.findViewById(R.id.close_img);
        commit = mView.findViewById(R.id.commit);
        commit_file = mView.findViewById(R.id.commit_file);
        start = mView.findViewById(R.id.start);
        edit_text = mView.findViewById(R.id.edit_text);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSystemSwitchListener.switchEdit(edit_text);


            }
        });

        close_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        commit_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileNameDialog fileNameDialog = new FileNameDialog(mContext);
                fileNameDialog.show();
                fileNameDialog.setOnSaveFileNameListener(new FileNameDialog.OnSaveFileNameListener() {
                    @Override
                    public void saveFileName(String name) {
                        fileNameDialog.dismiss();
                        UUtils.setFileString(new File(Environment.getExternalStorageDirectory(),"/xinhao/windows_config/" + name + ".txt"),edit_text.getText().toString());
                    }
                });


            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStartCommand != null)
                mStartCommand.startCommand(edit_text.getText().toString());
            }
        });

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mStartCommand != null)
                mEditStartCommand.editCommand(edit_text.getText().toString());

            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.dialog_edit_windows;
    }

    public void setStringData(String data){


        edit_text.setText(data);


    }

    public void setVisible(boolean isVisible){

        if(!isVisible){
            cancel.setVisibility(View.INVISIBLE);
            commit.setVisibility(View.INVISIBLE);
            commit_file.setVisibility(View.VISIBLE);
        }else{
            cancel.setVisibility(View.VISIBLE);
            commit.setVisibility(View.VISIBLE);
            commit_file.setVisibility(View.GONE);
        }

    }

    private SystemSwitchListener mSystemSwitchListener;

    public void setSystemSwitchListener(SystemSwitchListener mSystemSwitchListener){
        this.mSystemSwitchListener = mSystemSwitchListener;
    }

    private EditStartCommand mEditStartCommand;

    public void setEditStartCommand(EditStartCommand mEditStartCommand){
        this.mEditStartCommand = mEditStartCommand;
    }

    private StartCommand mStartCommand;

    public void setStartCommand(StartCommand mStartCommand){
        this.mStartCommand = mStartCommand;
    }

    //恢复默认值
    public interface SystemSwitchListener{

        void switchEdit(EditText editText);

    }
    //修改
    public interface EditStartCommand{
        void editCommand(String string);

    }

    //启动

    public interface StartCommand{
        void startCommand(String string);

    }
}
