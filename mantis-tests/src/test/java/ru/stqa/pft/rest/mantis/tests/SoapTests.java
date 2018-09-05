package ru.stqa.pft.rest.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.rest.mantis.models.Issue;
import ru.stqa.pft.rest.mantis.models.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class SoapTests extends TestBase{

    @Test
    public void testGetProject() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(1);
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testIssue () throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test issue").withDescription("test issue description")
                .withProject(projects.iterator().next());
       Issue create = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), create.getSummary());
    }
}
