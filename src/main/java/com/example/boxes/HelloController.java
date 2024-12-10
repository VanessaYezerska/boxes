package com.example.boxes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox answComplexity;

    @FXML
    private CheckBox answConsensus;
    @FXML
    private CheckBox answFlexibility;
    @FXML
    private CheckBox answFriendship;

    @FXML
    private Label answerInCheckBox;

    @FXML
    private Button btnGetAnswerToCheckBox;

    // ChoiceBox
    @FXML
    private Button btnGetAnswerToChoiceBox;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label answerInChoiceBox;

    // ComboBox
    @FXML
    private Label answerInComboBox;
    @FXML
    private ComboBox<String> comboBox;

    // RadioButtons
    @FXML
    private RadioButton RBtnProperties;
    @FXML
    private RadioButton RBtnLayout;
    @FXML
    private RadioButton RBtnCode;
    @FXML
    private RadioButton RBtnHierarchy;
    @FXML
    private Label answerInRadioButton;

    private ToggleGroup radioToggleGroup;

    // Обробка натискання кнопки CheckBox
    @FXML
    void getAnswerToCheckBox(ActionEvent event) {
        StringBuilder variants = new StringBuilder("Ваша відповідь: ");
        ArrayList<CheckBox> selectedAnswers = new ArrayList<>();

        if (answConsensus.isSelected()) {
            variants.append("Погодженість, ");
            selectedAnswers.add(answConsensus);
        }
        if (answFriendship.isSelected()) {
            variants.append("Дружність, ");
            selectedAnswers.add(answFriendship);
        }
        if (answFlexibility.isSelected()) {
            variants.append("Гнучкість, ");
            selectedAnswers.add(answFlexibility);
        }
        if (answComplexity.isSelected()) {
            variants.append("Складність, ");
            selectedAnswers.add(answComplexity);
        }

        if (selectedAnswers.isEmpty()) {
            answerInCheckBox.setText("Ви не вибрали жодного варіанта.");
        } else if (selectedAnswers.size() == 3 && selectedAnswers.contains(answConsensus)
                && selectedAnswers.contains(answFriendship) && selectedAnswers.contains(answFlexibility)) {
            answerInCheckBox.setText(variants + "є правильною.");
        } else {
            answerInCheckBox.setText(variants + "не є правильною.");
        }
    }

    // Обробка натискання кнопки ChoiceBox
    @FXML
    void getAnswerToChoiceBox(ActionEvent event) {
        String answer = choiceBox.getValue();
        if (answer == null) {
            answerInChoiceBox.setText("Ви не вибрали жодного варіанта.");
            return;
        }

        if (answer.equals("Правильно")) {
            answerInChoiceBox.setText("Відповідь: ви надали правильну відповідь.");
        } else {
            answerInChoiceBox.setText("Відповідь: ви надали неправильну відповідь.");
        }
    }

    // Обробка натискання ComboBox
    @FXML
    void getAnswerInComboBox(ActionEvent event) {
        String selectedValue = comboBox.getValue();
        if (selectedValue == null) {
            answerInComboBox.setText("Ви не вибрали жодного варіанта.");
            return;
        }

        if (selectedValue.equals("BorderPane")) {
            answerInComboBox.setText("Відповідь: " + selectedValue + " правильна.");
        } else {
            answerInComboBox.setText("Відповідь: " + selectedValue + " неправильна.");
        }
    }

    // Обробка RadioButton
    @FXML
    void getAnswerInRadioButton(ActionEvent event) {
        RadioButton selectedButton = (RadioButton) radioToggleGroup.getSelectedToggle();
        if (selectedButton == null) {
            answerInRadioButton.setText("Ви не вибрали жодного варіанта.");
            return;
        }

        String answer = selectedButton.getText();
        switch (answer) {
            case "Properties":
                answerInRadioButton.setText("Відповідь: Properties є правильною.");
                break;
            default:
                answerInRadioButton.setText("Відповідь: " + answer + " не є правильною.");
        }
    }
    // Обробка меню очищення
    @FXML
    void menuClearAll(ActionEvent event) {
        answConsensus.setSelected(false);
        answFriendship.setSelected(false);
        answFlexibility.setSelected(false);
        answComplexity.setSelected(false);
    }

    @FXML
    void menuClearFirstHalf(ActionEvent event) {
        answConsensus.setSelected(false);
        answFriendship.setSelected(false);
    }

    @FXML
    void menuClearSecondHalf(ActionEvent event) {
        answFlexibility.setSelected(false);
        answComplexity.setSelected(false);
    }

    // Підказка для користувача
    @FXML
    void getHelp(ActionEvent event) {
        answerInCheckBox.setText("Натисніть на квадратики, щоб вибрати відповідь.");
    }

    @FXML
    void initialize() {
        assert answerInRadioButton != null : "fx:id=\"answerInRadioButton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnGetAnswerToCheckBox != null : "fx:id=\"btnGetAnswerToCheckBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnGetAnswerToChoiceBox != null : "fx:id=\"btnGetAnswerToChoiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnProperties != null : "fx:id=\"RBtnProperties\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answComplexity != null : "fx:id=\"answComplexity\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInChoiceBox != null : "fx:id=\"answerInChoiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnCode != null : "fx:id=\"RBtnCode\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnHierarchy != null : "fx:id=\"RBtnHierarchy\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInCheckBox != null : "fx:id=\"answerInCheckBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnLayout != null : "fx:id=\"RBtnLayout\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answConsensus != null : "fx:id=\"answConsensus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answFriendship != null : "fx:id=\"answFriendship\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInComboBox != null : "fx:id=\"answerInComboBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answFlexibility != null : "fx:id=\"answFlexibility\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'hello-view.fxml'.";


        choiceBox.getItems().addAll("Правильно", "Неправильно");
        comboBox.getItems().addAll("BorderPane", "AnchorPane", "HBox");

        radioToggleGroup = new ToggleGroup();
        RBtnProperties.setToggleGroup(radioToggleGroup);
        RBtnLayout.setToggleGroup(radioToggleGroup);
        RBtnCode.setToggleGroup(radioToggleGroup);
        RBtnHierarchy.setToggleGroup(radioToggleGroup);

        answerInCheckBox.setText("");
        answerInChoiceBox.setText("");
        answerInComboBox.setText("");
        answerInRadioButton.setText("");



    }
}


