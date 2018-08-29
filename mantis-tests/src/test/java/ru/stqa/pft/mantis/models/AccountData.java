package ru.stqa.pft.mantis.models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class AccountData {

        @Id
        @Column(name = "id")
        private int id = Integer.MAX_VALUE;

        @Column(name = "username")
        private String username;

        @Column(name = "email")
        private String email;

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public AccountData withId(int id) {
            this.id = id;
            return this;
        }


        public AccountData withUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountData withEmail(String email) {
            this.email = email;
            return this;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountData accountData = (AccountData) o;
        return id == accountData.id &&
                Objects.equals(username, accountData.username) &&
                Objects.equals(email, accountData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
