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

import android.accounts.IAccountManagerResponse;
import android.accounts.Account;
import android.os.Bundle;

/**
 * Central application service that provides account management.
 */
interface IAccountManager {
    String getPassword(in Account account);
    String getUserData(in Account account, String key);
    Account[] getAccounts();
    Account[] getAccountsByType(String accountType);
    boolean addAccount(in Account account, String password, in Bundle extras);
    void removeAccount(in Account account);
    void invalidateAuthToken(String accountType, String authToken);
    String peekAuthToken(in Account account, String authTokenType);
    void setAuthToken(in Account account, String authTokenType, String authToken);
    void setPassword(in Account account, String password);
    void clearPassword(in Account account);
    void setUserData(in Account account, String key, String value);

    // interactive

    void getAuthToken(in IAccountManagerResponse response, in Account account, String authTokenType,
        boolean notifyOnAuthFailure);
    void addAccountInteractively(in IAccountManagerResponse response, String accountType);
    void authenticateAccount(in IAccountManagerResponse response, in Account account,
        String password);
    void updatePassword(in IAccountManagerResponse response, in Account account);
    void editProperties(in IAccountManagerResponse response, String accountType);

    // not interactive
    void getPasswordStrength(in IAccountManagerResponse response, String accountType,
        String password);
    void checkUsernameExistence(in IAccountManagerResponse response, String accountType,
        String username);
}
