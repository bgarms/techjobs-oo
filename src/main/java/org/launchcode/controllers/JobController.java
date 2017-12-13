package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        model.addAttribute("singleJob", jobData.findById(id));
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    // The JobForm Object (and errors) is sent to the controller.

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // Checks if JobForm contains errors (as defined in the JobForm Class)

        if ( errors.hasErrors()){  // If errors are present, the errors attribute is added to the model
                                    // and displayed on the new-job template.

            model.addAttribute("errors", errors);
            return "new-job";
        }

        // If No errors, a Job Object is created (called newJob).

        Job newJob = new Job(jobForm.getName(),
                                jobData.getEmployers().findById(jobForm.getEmployerId()),
                                jobData.getLocations().findById(jobForm.getLocation()),
                                jobData.getPositionTypes().findById(jobForm.getPositionType()),
                                jobData.getCoreCompetencies().findById(jobForm.getCoreCompetency()));

        jobData.add(newJob);

        // newJob is added to the jobData Model. (called singleJob in HTML)

        model.addAttribute("singleJob", newJob);

        // Redirect will display the newJob ID #, in the jobData Model.

        return "redirect:/job?id=" + newJob.getId();

    }
}
