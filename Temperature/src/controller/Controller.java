package controller;

import view.GuiForm;

public class Controller {
    private GuiForm guiForm;

    public Controller(GuiForm guiForm) {
        this.guiForm = guiForm;
    }

    public void initController() {
        guiForm.getConvertButton().addActionListener(e -> guiForm.setResult());
    }
}
