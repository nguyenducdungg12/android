// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogupdatestudentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonNoUpdate;

  @NonNull
  public final Button buttonYesupdateStudent;

  private DialogupdatestudentBinding(@NonNull LinearLayout rootView, @NonNull Button buttonNoUpdate,
      @NonNull Button buttonYesupdateStudent) {
    this.rootView = rootView;
    this.buttonNoUpdate = buttonNoUpdate;
    this.buttonYesupdateStudent = buttonYesupdateStudent;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogupdatestudentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogupdatestudentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialogupdatestudent, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogupdatestudentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonNoUpdate;
      Button buttonNoUpdate = rootView.findViewById(id);
      if (buttonNoUpdate == null) {
        break missingId;
      }

      id = R.id.buttonYesupdateStudent;
      Button buttonYesupdateStudent = rootView.findViewById(id);
      if (buttonYesupdateStudent == null) {
        break missingId;
      }

      return new DialogupdatestudentBinding((LinearLayout) rootView, buttonNoUpdate,
          buttonYesupdateStudent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
