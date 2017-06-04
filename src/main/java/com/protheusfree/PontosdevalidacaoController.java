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

@Named("pontosdevalidacaoController")
@SessionScoped
public class PontosdevalidacaoController implements Serializable {

    @EJB
    private com.protheusfree.PontosdevalidacaoFacade ejbFacade;
    private List<Pontosdevalidacao> items = null;
    private Pontosdevalidacao selected;

    public PontosdevalidacaoController() {
    }

    public Pontosdevalidacao getSelected() {
        return selected;
    }

    public void setSelected(Pontosdevalidacao selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PontosdevalidacaoFacade getFacade() {
        return ejbFacade;
    }

    public Pontosdevalidacao prepareCreate() {
        selected = new Pontosdevalidacao();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PontosdevalidacaoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PontosdevalidacaoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PontosdevalidacaoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Pontosdevalidacao> getItems() {
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

    public Pontosdevalidacao getPontosdevalidacao(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Pontosdevalidacao> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Pontosdevalidacao> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Pontosdevalidacao.class)
    public static class PontosdevalidacaoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PontosdevalidacaoController controller = (PontosdevalidacaoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pontosdevalidacaoController");
            return controller.getPontosdevalidacao(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pontosdevalidacao) {
                Pontosdevalidacao o = (Pontosdevalidacao) object;
                return getStringKey(o.getIdpontosdevalidacao());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Pontosdevalidacao.class.getName()});
                return null;
            }
        }

    }

}
