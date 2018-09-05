package ru.stqa.pft.rest.tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

    public Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueOpen(int issueId) throws IOException {
        String json = getExecutor()
                .execute(Request.Get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonArray issues = parsed.getAsJsonObject().get("issues").getAsJsonArray();
        String issueStatus = issues.get(0).getAsJsonObject().get("state_name").getAsString();
        if (issueStatus.equals("Resolved") || issueStatus.equals("Closed")) {
            return false;
        } else {
            return true;
        }
    }

}
