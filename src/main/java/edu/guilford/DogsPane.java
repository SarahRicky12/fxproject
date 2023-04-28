package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class DogsPane extends GridPane {

    // Attributes

    private Dogs dog;

    private Label infoLabel;
    private Label nameLabel;
    private Label breedLabel;
    private Label ageLabel;
    private Label weightLabel;

    private Button submitButton;

    private TextField nameField;
    private TextField breedField;
    private TextField ageField;

    //Step 1: Declare a slider for the weight
    private Slider weightSlider;

    private ImageView dogView;

    public DogsPane(Dogs dog) {
        this.dog = dog;

        submitButton = new Button("Submit Changes");

        infoLabel = new Label("Enter Your Dog's Information Below");
        nameLabel = new Label("Name:" + dog.getName());
        breedLabel = new Label("Breed:" + dog.getBreed());
        ageLabel = new Label("Age:" + dog.getAge());
        weightLabel = new Label("Weight:" + dog.getWeight());

        nameField = new TextField();
        breedField = new TextField();
        ageField = new TextField();

        //Step 2: Instantiate a slider that goes from 0 to 120 with a default value of 50
        weightSlider = new Slider(0, 120, 50);


        File dogImage = new File(this.getClass().getResource("cartoon-dog.png").getPath());
        dogView = new ImageView(dogImage.toURI().toString());

        //add the infoLabel to the top of the pane
        this.add(infoLabel, 0, 0, 2, 1);

        this.add(nameLabel, 0, 1);
        this.add(breedLabel, 0, 2);
        this.add(ageLabel, 0, 3);
        this.add(weightLabel, 0, 4);
        //add the nameField next to the nameLabel
        //create numbers to the slider
        //Step 3: Add the weightSlider to the pane and change the tick settings
        weightSlider.setShowTickMarks(true);
        weightSlider.setShowTickLabels(true);
        weightSlider.setMajorTickUnit(20);
        this.add(nameField, 1, 1);
        //add the breedField next to the breedLabel
        this.add(breedField, 1, 2);
        //add the ageField next to the ageLabel
        this.add(ageField, 1, 3);
        //add the weightSlider next to the weightLabel
        this.add(weightSlider, 1, 4);
        //add the submitButton under the weightSlider
        this.add(submitButton, 1, 5);

        //add the dogView to the farthest right of the pane
        this.add(dogView, 2, 0, 1, 6);
       
        //set the size of the dogView
        dogView.setFitHeight(350);
        dogView.setPreserveRatio(true);

        this.setStyle("-fx-background-color: pink");

        //Add a listener for the button that changes the labels 
        submitButton.setOnAction(e -> {
            nameLabel.setText("Name: " + dog.getName());
            breedLabel.setText("Breed: " + dog.getBreed());
            ageLabel.setText("Age: " + dog.getAge());
            weightLabel.setText("Weight: " + String.format("%.2f", dog.getWeight()));

            //update the dog's attributes with the new data 
            dog.setName(nameField.getText());
            dog.setBreed(breedField.getText());
            dog.setAge(Integer.parseInt(ageField.getText()));
            //Step 4 & 5: Update the dog's weight with the slider's value
            dog.setWeight(weightSlider.getValue());
            System.out.println(e.toString());
        });

    }

}
