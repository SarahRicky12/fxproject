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
    private Label errorLabel;

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
        errorLabel = new Label("");
        // make the errorLabel red
        errorLabel.setStyle("-fx-text-fill: red;");
        //make the errorLabel bold
        errorLabel.setStyle("-fx-font-weight: bold;");
        //make the errorLabel on two lines
        errorLabel.setWrapText(true);

        
        nameField = new TextField();
        //use the disallowNumbers method for nameField
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                nameField.setText(newValue.replaceAll("\\d", ""));
                errorLabel.setText("You have entered a number into the name field");
            } else {
                errorLabel.setText("");
            }
        }); //can't quite figure out how to make this work for every single time the user presses a number
        //if the user starts out with a number, an error occurs, but if they throw a number in the middle of the name, it doesn't work
        //use the disallowNumbers method for nameField
        //I am getting an error for this method below 
        //nameField.disallowsNumbers();

        //make it so that the first letter in the nameField is capitalized
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[A-Za-z]")) {
                nameField.setText(newValue.toUpperCase());
            } 
        }); //this makes it so that the first letter enter must be capitol, it automatically capitalizes the first letter so there is no reason to make an error statement

        //use the noSpecialCharacters() method for nameField
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[^A-Za-z0-9]")) {
                nameField.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
                errorLabel.setText("You have entered a special character into the name field");
            } else {
                errorLabel.setText("");
            }
        }); //can't quite figure out how to make this work for every single time the user presses a number


        breedField = new TextField();
        //use the disallowNumbers method for breedField
        breedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                breedField.setText(newValue.replaceAll("\\d", ""));
                errorLabel.setText("You have entered a number into the breed field");
            } else {
                errorLabel.setText("");
            }
        }); 
        //use the noSpecialCharacters() method for breedField
        breedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[^A-Za-z0-9]")) {
                breedField.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
                errorLabel.setText("You have entered a special character into the breed field");
            } else {
                errorLabel.setText("");
            }
        }); //can't quite figure out how to make this work for every single time the user presses a number

        //make it so that the first letter in the breedField is capitalized
        breedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[A-Za-z]")) {
                breedField.setText(newValue.toUpperCase());
            } 
        }); //this makes it so that the first letter enter must be capitol, it automatically capitalizes the first letter so there is no reason to make an error statement

        ageField = new TextField();
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                ageField.setText(newValue.replaceAll("[^\\d]", ""));
                errorLabel.setText("You have entered either a letter or decimal-number into the age field. Please enter an integer.");
            } else {
                errorLabel.setText("");
            }
        });//again this only works for the first key entered, not for every key entered
        //use the noSpecialCharacters() method for ageField
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[^A-Za-z0-9]")) {
                ageField.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
                errorLabel.setText("You have entered a special character into the age field");
            } else {
                errorLabel.setText("");
            }
        }); //can't quite figure out how to make this work for every single time the user presses a number

        //create bounds for ageField (0-28)
        //ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            //if (newValue.matches("[]")) {
                //ageField.setText(newValue.replaceAll("[0-9]", ""));
                //errorLabel.setText("You have entered a number outside of the bounds of the age field");
            //} else {
                //errorLabel.setText("");
            //}
        //}); 
        //can't figure out how to set the bounds for the ageField
        //I tried changing the value in the "newValue.matches" to < 28, but that did not work

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
        this.add(errorLabel, 0, 5);
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
            //update the dog's attributes with the new data 
            //use the disallowNumbers method when setting the name
            
            dog.setName(nameField.getText());
            dog.setBreed(breedField.getText());
            
            dog.setAge(Integer.parseInt(ageField.getText()));
            //Step 4 & 5: Update the dog's weight with the slider's value
            dog.setWeight(weightSlider.getValue());
            System.out.println(e.toString());

            nameLabel.setText("Name: " + dog.getName());
            breedLabel.setText("Breed: " + dog.getBreed());
            ageLabel.setText("Age: " + dog.getAge());
            weightLabel.setText("Weight: " + String.format("%.2f", dog.getWeight()));
           
        });

        submitButton.setOnAction(e -> {
            if (nameField.getText().isEmpty() || breedField.getText().isEmpty() || ageField.getText().isEmpty()) {
                errorLabel.setText("You have left a field empty. Please fill in all fields.");
            } else {
                errorLabel.setText("");
            }
        });

    }


    //create a method that disallows the user to enter numbers into the nameField
    public void disallowNumbers() {
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\D*")) {
                nameField.setText(newValue.replaceAll("[^\\D]", ""));
                // tell the user they have entered a number into the namefield by printing the message into errorLabel
                errorLabel.setText("You have entered a number into the name field");
            } else {
                errorLabel.setText("");
            }
        });
    }

    //create a method that disallows the user to enter numbers into the breedField
    public void disallowNumbers2() {
        breedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\D*")) {
                breedField.setText(newValue.replaceAll("[^\\D]", ""));
                // tell the user they have entered a number into the breedfield by printing the message into errorLabel
                errorLabel.setText("You have entered a number into the breed field");
            } else {
                errorLabel.setText("");
            }
        });
    }

    //create a method that disallows the user to enter numbers into the ageField
    public void onlyNumbers() {
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\D*")) {
                ageField.setText(newValue.replaceAll("[^\\D]", ""));
                // tell the user they have entered a number into the agefield by printing the message into errorLabel
                errorLabel.setText("You have entered a letter into the age field. Please enter an integer.");
            } else {
                errorLabel.setText("");
            }
        });
    }

    //create a method that prevents the user from entering a double into the ageField
    public void noDoubles() {
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                ageField.setText(newValue.replaceAll("[^\\d]", ""));
                // tell the user they have entered a letter into the agefield by printing the message into errorLabel
                errorLabel.setText("You have entered an invalid number into the age field. Please enter an integer.");
            } else {
                errorLabel.setText("");
            }
        });
}

//create a method that prevents the user from entering a special character into the nameField, breedField, and ageField
public void noSpecialCharacters() {
    nameField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\w*")) {
            nameField.setText(newValue.replaceAll("[^\\w]", ""));
            // tell the user they have entered a special character into the namefield by printing the message into errorLabel
            errorLabel.setText("You have entered a special character into the name field");
        } else {
            errorLabel.setText("");
        }
    });
    breedField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\w*")) {
            breedField.setText(newValue.replaceAll("[^\\w]", ""));
            // tell the user they have entered a special character into the breedfield by printing the message into errorLabel
            errorLabel.setText("You have entered a special character into the breed field");
        } else {
            errorLabel.setText("");
        }
    });
    ageField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\w*")) {
            ageField.setText(newValue.replaceAll("[^\\w]", ""));
            // tell the user they have entered a special character into the agefield by printing the message into errorLabel
            errorLabel.setText("You have entered a special character into the age field");
        } else {
            errorLabel.setText("");
        }
    });
}


}