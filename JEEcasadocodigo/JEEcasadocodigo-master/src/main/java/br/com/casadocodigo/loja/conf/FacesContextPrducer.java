package br.com.casadocodigo.loja.conf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextPrducer {

    @RequestScoped
    @Produces
    public FacesContext getFacesContext(){
            return FacesContext.getCurrentInstance();
    }
}
