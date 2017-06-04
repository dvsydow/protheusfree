package com.protheusfree;

import com.protheusfree.util.JsfUtil;
import com.protheusfree.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("consultor1Controller")
@SessionScoped
public class Consultor1Controller implements Serializable {

    @EJB
    private com.protheusfree.Consultor1Facade ejbFacade;
    private List<Consultor1> items = null;
    private Consultor1 selected;

    public Consultor1Controller() {
    }

    public Consultor1 getSelected() {
        return selected;
    }

    public void setSelected(Consultor1 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getConsultor1PK().setIdusuario(selected.getUsuario().getIdusuario());
    }

    protected void initializeEmbeddableKey() {
        selected.setConsultor1PK(new com.protheusfree.Consultor1PK());
    }

    private Consultor1Facade getFacade() {
        return ejbFacade;
    }

    public Consultor1 prepareCreate() {
        selected = new Consultor1();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Consultor1Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Consultor1Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Consultor1Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Consultor1> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Consultor1 getConsultor1(com.protheusfree.Consultor1PK id) {
        return getFacade().find(id);
    }

    public List<Consultor1> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Consultor1> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Consultor1.class)
    public static class Consultor1ControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Consultor1Controller controller = (Consultor1Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "consultor1Controller");
            return controller.getConsultor1(getKey(value));
        }

        com.protheusfree.Consultor1PK getKey(String value) {
            com.protheusfree.Consultor1PK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.protheusfree.Consultor1PK();
            key.setIdconsultor(Integer.parseInt(values[0]));
            key.setIdusuario(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.protheusfree.Consultor1PK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdconsultor());
            sb.append(SEPARATOR);
            sb.append(value.getIdusuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Consultor1) {
                Consultor1 o = (Consultor1) object;
                return getStringKey(o.getConsultor1PK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Consultor1.class.getName()});
                return null;
            }
        }

    }

}
