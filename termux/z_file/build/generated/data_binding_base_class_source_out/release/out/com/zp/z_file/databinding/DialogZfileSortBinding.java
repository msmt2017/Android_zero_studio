// Generated by view binder compiler. Do not edit!
package com.zp.z_file.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zp.z_file.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogZfileSortBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView zfileDialogSortCancel;

  @NonNull
  public final Button zfileDialogSortDown;

  @NonNull
  public final RadioButton zfileSequenceAsc;

  @NonNull
  public final RadioButton zfileSequenceDesc;

  @NonNull
  public final RadioGroup zfileSequenceGroup;

  @NonNull
  public final LinearLayout zfileSequenceLayout;

  @NonNull
  public final RadioButton zfileSortByDate;

  @NonNull
  public final RadioButton zfileSortByDefault;

  @NonNull
  public final RadioButton zfileSortByName;

  @NonNull
  public final RadioButton zfileSortBySize;

  @NonNull
  public final RadioGroup zfileSortGroup;

  private DialogZfileSortBinding(@NonNull LinearLayout rootView,
      @NonNull TextView zfileDialogSortCancel, @NonNull Button zfileDialogSortDown,
      @NonNull RadioButton zfileSequenceAsc, @NonNull RadioButton zfileSequenceDesc,
      @NonNull RadioGroup zfileSequenceGroup, @NonNull LinearLayout zfileSequenceLayout,
      @NonNull RadioButton zfileSortByDate, @NonNull RadioButton zfileSortByDefault,
      @NonNull RadioButton zfileSortByName, @NonNull RadioButton zfileSortBySize,
      @NonNull RadioGroup zfileSortGroup) {
    this.rootView = rootView;
    this.zfileDialogSortCancel = zfileDialogSortCancel;
    this.zfileDialogSortDown = zfileDialogSortDown;
    this.zfileSequenceAsc = zfileSequenceAsc;
    this.zfileSequenceDesc = zfileSequenceDesc;
    this.zfileSequenceGroup = zfileSequenceGroup;
    this.zfileSequenceLayout = zfileSequenceLayout;
    this.zfileSortByDate = zfileSortByDate;
    this.zfileSortByDefault = zfileSortByDefault;
    this.zfileSortByName = zfileSortByName;
    this.zfileSortBySize = zfileSortBySize;
    this.zfileSortGroup = zfileSortGroup;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogZfileSortBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogZfileSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_zfile_sort, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogZfileSortBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.zfile_dialog_sort_cancel;
      TextView zfileDialogSortCancel = ViewBindings.findChildViewById(rootView, id);
      if (zfileDialogSortCancel == null) {
        break missingId;
      }

      id = R.id.zfile_dialog_sort_down;
      Button zfileDialogSortDown = ViewBindings.findChildViewById(rootView, id);
      if (zfileDialogSortDown == null) {
        break missingId;
      }

      id = R.id.zfile_sequence_asc;
      RadioButton zfileSequenceAsc = ViewBindings.findChildViewById(rootView, id);
      if (zfileSequenceAsc == null) {
        break missingId;
      }

      id = R.id.zfile_sequence_desc;
      RadioButton zfileSequenceDesc = ViewBindings.findChildViewById(rootView, id);
      if (zfileSequenceDesc == null) {
        break missingId;
      }

      id = R.id.zfile_sequenceGroup;
      RadioGroup zfileSequenceGroup = ViewBindings.findChildViewById(rootView, id);
      if (zfileSequenceGroup == null) {
        break missingId;
      }

      id = R.id.zfile_sequenceLayout;
      LinearLayout zfileSequenceLayout = ViewBindings.findChildViewById(rootView, id);
      if (zfileSequenceLayout == null) {
        break missingId;
      }

      id = R.id.zfile_sort_by_date;
      RadioButton zfileSortByDate = ViewBindings.findChildViewById(rootView, id);
      if (zfileSortByDate == null) {
        break missingId;
      }

      id = R.id.zfile_sort_by_default;
      RadioButton zfileSortByDefault = ViewBindings.findChildViewById(rootView, id);
      if (zfileSortByDefault == null) {
        break missingId;
      }

      id = R.id.zfile_sort_by_name;
      RadioButton zfileSortByName = ViewBindings.findChildViewById(rootView, id);
      if (zfileSortByName == null) {
        break missingId;
      }

      id = R.id.zfile_sort_by_size;
      RadioButton zfileSortBySize = ViewBindings.findChildViewById(rootView, id);
      if (zfileSortBySize == null) {
        break missingId;
      }

      id = R.id.zfile_sortGroup;
      RadioGroup zfileSortGroup = ViewBindings.findChildViewById(rootView, id);
      if (zfileSortGroup == null) {
        break missingId;
      }

      return new DialogZfileSortBinding((LinearLayout) rootView, zfileDialogSortCancel,
          zfileDialogSortDown, zfileSequenceAsc, zfileSequenceDesc, zfileSequenceGroup,
          zfileSequenceLayout, zfileSortByDate, zfileSortByDefault, zfileSortByName,
          zfileSortBySize, zfileSortGroup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
