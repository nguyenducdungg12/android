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

public final class DialogaddBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonNo;

  @NonNull
  public final Button buttonYes;

  private DialogaddBinding(@NonNull LinearLayout rootView, @NonNull Button buttonNo,
      @NonNull Button buttonYes) {
    this.rootView = rootView;
    this.buttonNo = buttonNo;
    this.buttonYes = buttonYes;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogaddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogaddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialogadd, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogaddBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonNo;
      Button buttonNo = rootView.findViewById(id);
      if (buttonNo == null) {
        break missingId;
      }

      id = R.id.buttonYes;
      Button buttonYes = rootView.findViewById(id);
      if (buttonYes == null) {
        break missingId;
      }

      return new DialogaddBinding((LinearLayout) rootView, buttonNo, buttonYes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
