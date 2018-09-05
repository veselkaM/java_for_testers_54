package ru.stqa.pft.mantis.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Accounts extends ForwardingSet<AccountData> {
    private Set<AccountData> delegate;

    public Accounts(Accounts accounts) {
        this.delegate = new HashSet<AccountData>(accounts.delegate);
    }

    public Accounts(Collection<AccountData> accounts) {
        this.delegate = new HashSet<AccountData>(accounts);
    }

    public Accounts() {
        this.delegate = new HashSet<AccountData>();
    }

    @Override
    protected Set<AccountData> delegate() {
        return delegate;
    }

    public Accounts without(AccountData account) {
        Accounts accounts = new Accounts(this);
        accounts.remove(accounts);
        return accounts;
    }

    }

