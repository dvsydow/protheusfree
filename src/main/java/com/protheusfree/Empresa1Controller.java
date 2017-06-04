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

@Named("empresa1Controller")
@SessionScoped
public class Empresa1Controller implements Serializable {

    @EJB
    private com.protheusfree.Empresa1Facade ejbFacade;
    private List<Empresa1> items = null;
    private Empresa1 selected;

    public Empresa1Controller() {
    }

    public Empresa1 getSelected() {
        return selected;
    }

    public void setSelected(Empresa1 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEmpresa1PK().setIdusuario(selected.getUsuario().getIdusuario());
    }

    protected void initializeEmbeddableKey() {
        selected.setEmpresa1PK(new com.protheusfree.Empresa1PK());
    }

    private Empresa1Facade getFacade() {
        return ejbFacade;
    }

    public Empresa1 prepareCreate() {
        selected = new Empresa1();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Empresa1Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Empresa1Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Empresa1Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Empresa1> getItems() {
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

    public Empresa1 getEmpresa1(com.protheusfree.Empresa1PK id) {
        return getFacade().find(id);
    }

    public List<Empresa1> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Empresa1> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Empresa1.class)
    public static class Empresa1ControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Empresa1Controller controller = (Empresa1Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empresa1Controller");
            return controller.getEmpresa1(getKey(value));
        }

        com.protheusfree.Empresa1PK getKey(String value) {
            com.protheusfree.Empresa1PK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.protheusfree.Empresa1PK();
            key.setIdempresa(Integer.parseInt(values[0]));
            key.setIdusuario(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.protheusfree.Empresa1PK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdempresa());
            sb.append(SEPARATOR);
            sb.append(value.getIdusuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Empresa1) {
                Empresa1 o = (Empresa1) object;
                return getStringKey(o.getEmpresa1PK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empresa1.class.getName()});
                return null;
            }
        }

    }

}
