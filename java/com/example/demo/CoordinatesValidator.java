package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator("coordinatesValidator")
public class CoordinatesValidator implements Validator {

    private DotConstraintsBean constraints = new DotConstraintsBean();

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"y validation failed","field must not be null");
            throw new ValidatorException(msg);
        }
        try{
            Double y = Double.parseDouble(value.toString());
            if (y >= constraints.getMAX_Y() || y <= constraints.getMIN_Y()){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"y validation failed","y must be in range (-3;3)");
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"y validation failed","y must be a number");
            throw new ValidatorException(msg);
        }
    }

}
