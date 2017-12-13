package org.launchcode.models.forms;

import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    // @NotNull and @Size creates requirements for the Form to has a name
    // that is at least 1 character long.

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    @NotNull
    @Size(min=1, message = "Employer may not be empty")
    private ArrayList<Employer> employers;

    @NotNull
    @Size(min=1, message = "Location may not be empty")
    private ArrayList<Location> locations;

    @NotNull
    @Size(min=1, message = "Must list a competency")
    private ArrayList<CoreCompetency> coreCompetencies;

    @NotNull
    @Size(min=1, message = "Position Type may not be blank")
    private ArrayList<PositionType> positionTypes;

    private int location;

    private int positionType;

    private int coreCompetency;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        employers = jobData.getEmployers().findAll();
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();

    }

    public int getPositionType() {
        return positionType;
    }

    public void setPositionType(int positionType) {
        this.positionType = positionType;
    }

    public int getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(int coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {

        this.employerId = employerId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
}
