// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnaddstudentadmin;

  @NonNull
  public final Button btnliststudentsubject;

  @NonNull
  public final Button btnlistsubjectadmin;

  @NonNull
  public final Button btnlogoutadmin;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView textView;

  private ActivityAdminBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnaddstudentadmin, @NonNull Button btnliststudentsubject,
      @NonNull Button btnlistsubjectadmin, @NonNull Button btnlogoutadmin,
      @NonNull ImageView imageView2, @NonNull TextView textView) {
    this.rootView = rootView;
    this.btnaddstudentadmin = btnaddstudentadmin;
    this.btnliststudentsubject = btnliststudentsubject;
    this.btnlistsubjectadmin = btnlistsubjectadmin;
    this.btnlogoutadmin = btnlogoutadmin;
    this.imageView2 = imageView2;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnaddstudentadmin;
      Button btnaddstudentadmin = rootView.findViewById(id);
      if (btnaddstudentadmin == null) {
        break missingId;
      }

      id = R.id.btnliststudentsubject;
      Button btnliststudentsubject = rootView.findViewById(id);
      if (btnliststudentsubject == null) {
        break missingId;
      }

      id = R.id.btnlistsubjectadmin;
      Button btnlistsubjectadmin = rootView.findViewById(id);
      if (btnlistsubjectadmin == null) {
        break missingId;
      }

      id = R.id.btnlogoutadmin;
      Button btnlogoutadmin = rootView.findViewById(id);
      if (btnlogoutadmin == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = rootView.findViewById(id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = rootView.findViewById(id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityAdminBinding((ConstraintLayout) rootView, btnaddstudentadmin,
          btnliststudentsubject, btnlistsubjectadmin, btnlogoutadmin, imageView2, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
