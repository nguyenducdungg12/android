// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUpdateSubjectBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText EditTextUpdateSubjectCredit;

  @NonNull
  public final EditText EditTextUpdateSubjectPlace;

  @NonNull
  public final EditText EditTextUpdateSubjectTitle;

  @NonNull
  public final Button buttonUpdateSubject;

  @NonNull
  public final Spinner spinnerDayUpdate;

  @NonNull
  public final Spinner spinnerTimeUpdate;

  private ActivityUpdateSubjectBinding(@NonNull LinearLayout rootView,
      @NonNull EditText EditTextUpdateSubjectCredit, @NonNull EditText EditTextUpdateSubjectPlace,
      @NonNull EditText EditTextUpdateSubjectTitle, @NonNull Button buttonUpdateSubject,
      @NonNull Spinner spinnerDayUpdate, @NonNull Spinner spinnerTimeUpdate) {
    this.rootView = rootView;
    this.EditTextUpdateSubjectCredit = EditTextUpdateSubjectCredit;
    this.EditTextUpdateSubjectPlace = EditTextUpdateSubjectPlace;
    this.EditTextUpdateSubjectTitle = EditTextUpdateSubjectTitle;
    this.buttonUpdateSubject = buttonUpdateSubject;
    this.spinnerDayUpdate = spinnerDayUpdate;
    this.spinnerTimeUpdate = spinnerTimeUpdate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUpdateSubjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUpdateSubjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_update_subject, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUpdateSubjectBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EditTextUpdateSubjectCredit;
      EditText EditTextUpdateSubjectCredit = rootView.findViewById(id);
      if (EditTextUpdateSubjectCredit == null) {
        break missingId;
      }

      id = R.id.EditTextUpdateSubjectPlace;
      EditText EditTextUpdateSubjectPlace = rootView.findViewById(id);
      if (EditTextUpdateSubjectPlace == null) {
        break missingId;
      }

      id = R.id.EditTextUpdateSubjectTitle;
      EditText EditTextUpdateSubjectTitle = rootView.findViewById(id);
      if (EditTextUpdateSubjectTitle == null) {
        break missingId;
      }

      id = R.id.buttonUpdateSubject;
      Button buttonUpdateSubject = rootView.findViewById(id);
      if (buttonUpdateSubject == null) {
        break missingId;
      }

      id = R.id.spinnerDayUpdate;
      Spinner spinnerDayUpdate = rootView.findViewById(id);
      if (spinnerDayUpdate == null) {
        break missingId;
      }

      id = R.id.spinnerTimeUpdate;
      Spinner spinnerTimeUpdate = rootView.findViewById(id);
      if (spinnerTimeUpdate == null) {
        break missingId;
      }

      return new ActivityUpdateSubjectBinding((LinearLayout) rootView, EditTextUpdateSubjectCredit,
          EditTextUpdateSubjectPlace, EditTextUpdateSubjectTitle, buttonUpdateSubject,
          spinnerDayUpdate, spinnerTimeUpdate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
