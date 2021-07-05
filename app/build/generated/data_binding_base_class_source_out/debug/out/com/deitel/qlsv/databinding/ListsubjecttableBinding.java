// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListsubjecttableBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView TextTimeSubjectTable;

  @NonNull
  public final TextView TextViewIdSubject;

  private ListsubjecttableBinding(@NonNull LinearLayout rootView,
      @NonNull TextView TextTimeSubjectTable, @NonNull TextView TextViewIdSubject) {
    this.rootView = rootView;
    this.TextTimeSubjectTable = TextTimeSubjectTable;
    this.TextViewIdSubject = TextViewIdSubject;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListsubjecttableBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListsubjecttableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.listsubjecttable, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListsubjecttableBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TextTimeSubjectTable;
      TextView TextTimeSubjectTable = rootView.findViewById(id);
      if (TextTimeSubjectTable == null) {
        break missingId;
      }

      id = R.id.TextViewIdSubject;
      TextView TextViewIdSubject = rootView.findViewById(id);
      if (TextViewIdSubject == null) {
        break missingId;
      }

      return new ListsubjecttableBinding((LinearLayout) rootView, TextTimeSubjectTable,
          TextViewIdSubject);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}