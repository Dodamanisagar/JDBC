package MySql.Crud.Creat;

public class TemplateDetails {
    private int ID;
    private String CODE;
    private String NAME;
    private String DESCRIPTION;
    private int PARENT;
    private int MODEL_TYPE_ID;
    private String MODIFIED_DATE;
    private String DEFAULT_PROPERTY;
    private String CREATED_BY;
    private int IS_VIEW;
    private int IS_ABSTRACT;

    public TemplateDetails(int ID, String CODE, String NAME, String DESCRIPTION,
                           int PARENT, int MODEL_TYPE_ID, String MODIFIED_DATE, String DEFAULT_PROPERTY,
                           String CREATED_BY, int IS_VIEW, int IS_ABSTRACT) {
        this.ID = ID;
        this.CODE = CODE;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.PARENT = PARENT;
        this.MODEL_TYPE_ID = MODEL_TYPE_ID;
        this.MODIFIED_DATE = MODIFIED_DATE;
        this.DEFAULT_PROPERTY = DEFAULT_PROPERTY;
        this.CREATED_BY = CREATED_BY;
        this.IS_VIEW = IS_VIEW;
        this.IS_ABSTRACT = IS_ABSTRACT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getPARENT() {
        return PARENT;
    }

    public void setPARENT(int PARENT) {
        this.PARENT = PARENT;
    }

    public int getMODEL_TYPE_ID() {
        return MODEL_TYPE_ID;
    }

    public void setMODEL_TYPE_ID(int MODEL_TYPE_ID) {
        this.MODEL_TYPE_ID = MODEL_TYPE_ID;
    }

    public String getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    public void setMODIFIED_DATE(String MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    public String getDEFAULT_PROPERTY() {
        return DEFAULT_PROPERTY;
    }

    public void setDEFAULT_PROPERTY(String DEFAULT_PROPERTY) {
        this.DEFAULT_PROPERTY = DEFAULT_PROPERTY;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public int getIS_VIEW() {
        return IS_VIEW;
    }

    public void setIS_VIEW(int IS_VIEW) {
        this.IS_VIEW = IS_VIEW;
    }

    public int getIS_ABSTRACT() {
        return IS_ABSTRACT;
    }

    public void setIS_ABSTRACT(int IS_ABSTRACT) {
        this.IS_ABSTRACT = IS_ABSTRACT;
    }
}
