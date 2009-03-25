/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.accounts;

import android.os.Parcelable;
import android.os.Parcel;

/**
 * Value type that represents an Account in the {@link AccountManager}. This object is
 * {@link Parcelable} and also overrides {@link #equals} and {@link #hashCode}, making it
 * suitable for use as the key of a {@link java.util.Map}
 */
public class Account implements Parcelable {
    public final String mName;
    public final String mType;

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account)o;
        return mName.equals(other.mName) && mType.equals(other.mType);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + mName.hashCode();
        result = 31 * result + mType.hashCode();
        return result;
    }

    public Account(String name, String type) {
        mName = name;
        mType = type;
    }

    public Account(Parcel in) {
        mName = in.readString();
        mType = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mType);
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String toString() {
        return "Account {name=" + mName + ", type=" + mType + "}";
    }
}
