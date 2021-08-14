package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private static Logic logic;
    private final Image coinRed = new Image("/coinBlue.png");
    private final Image coinBlue = new Image("/coinGreen.png");
    private final Image blank = new Image("/blank.png");
    private final Map<String,ImageView> imageViewMap = new TreeMap<>();

    //Row 0
    @FXML
    ImageView imageView00 = new ImageView();
    @FXML
    ImageView imageView01 = new ImageView();
    @FXML
    ImageView imageView02 = new ImageView();
    @FXML
    ImageView imageView03 = new ImageView();
    @FXML
    ImageView imageView04 = new ImageView();
    @FXML
    ImageView imageView05 = new ImageView();
    @FXML
    ImageView imageView06 = new ImageView();
    //Row 1
    @FXML
    ImageView imageView10 = new ImageView();
    @FXML
    ImageView imageView11 = new ImageView();
    @FXML
    ImageView imageView12 = new ImageView();
    @FXML
    ImageView imageView13 = new ImageView();
    @FXML
    ImageView imageView14 = new ImageView();
    @FXML
    ImageView imageView15 = new ImageView();
    @FXML
    ImageView imageView16 = new ImageView();
    //Row 2
    @FXML
    ImageView imageView20 = new ImageView();
    @FXML
    ImageView imageView21 = new ImageView();
    @FXML
    ImageView imageView22 = new ImageView();
    @FXML
    ImageView imageView23 = new ImageView();
    @FXML
    ImageView imageView24 = new ImageView();
    @FXML
    ImageView imageView25 = new ImageView();
    @FXML
    ImageView imageView26 = new ImageView();
    //Row 3
    @FXML
    ImageView imageView30 = new ImageView();
    @FXML
    ImageView imageView31 = new ImageView();
    @FXML
    ImageView imageView32 = new ImageView();
    @FXML
    ImageView imageView33 = new ImageView();
    @FXML
    ImageView imageView34 = new ImageView();
    @FXML
    ImageView imageView35 = new ImageView();
    @FXML
    ImageView imageView36 = new ImageView();
    //Row 4
    @FXML
    ImageView imageView40 = new ImageView();
    @FXML
    ImageView imageView41 = new ImageView();
    @FXML
    ImageView imageView42 = new ImageView();
    @FXML
    ImageView imageView43 = new ImageView();
    @FXML
    ImageView imageView44 = new ImageView();
    @FXML
    ImageView imageView45 = new ImageView();
    @FXML
    ImageView imageView46 = new ImageView();
    //Row 5
    @FXML
    ImageView imageView50 = new ImageView();
    @FXML
    ImageView imageView51 = new ImageView();
    @FXML
    ImageView imageView52 = new ImageView();
    @FXML
    ImageView imageView53 = new ImageView();
    @FXML
    ImageView imageView54 = new ImageView();
    @FXML
    ImageView imageView55 = new ImageView();
    @FXML
    ImageView imageView56 = new ImageView();

    @FXML
    Label label = new Label();
    @FXML
    Button restartButton = new Button();

    @FXML
    public void imageViewClicked(MouseEvent mouseEvent){
        String columnNumber= mouseEvent.getSource().toString().substring(23,24);
        if(logic.checkIsGameRunning()){
            String mapKey = logic.playTurn(Integer.parseInt(columnNumber));
            ImageView imageView = imageViewMap.get(mapKey);
            if(!mapKey.equals("filled")){
                if(logic.getTurn()==1){
                    imageView.setImage(coinRed);
                }else{
                    imageView.setImage(coinBlue);
                }
            }
        }
        restartButton.setVisible(!logic.checkIsGameRunning());
        if(!logic.checkIsGameRunning() && !logic.isDrawn()){
            String player = (logic.getTurn()==7) ? "Player1" : "Player2";
            label.setText(player + " has won!");
        }else if(logic.isDrawn()){
            label.setText("It is a draw!");
        }
    }

    @FXML
    public void restartGame(){
        logic.restartGame();
        ImageView blankImageView;
        for (Map.Entry<String,ImageView> entry : imageViewMap.entrySet()){
            blankImageView = entry.getValue();
            blankImageView.setImage(blank);
            label.setText("");
            restartButton.setVisible(false);
        }
    }

    public void initialize(){
        logic = new Logic();

        //Row 0
        imageViewMap.put("00",imageView00);
        imageViewMap.put("01",imageView01);
        imageViewMap.put("02",imageView02);
        imageViewMap.put("03",imageView03);
        imageViewMap.put("04",imageView04);
        imageViewMap.put("05",imageView05);
        imageViewMap.put("06",imageView06);
        //Row1
        imageViewMap.put("10",imageView10);
        imageViewMap.put("11",imageView11);
        imageViewMap.put("12",imageView12);
        imageViewMap.put("13",imageView13);
        imageViewMap.put("14",imageView14);
        imageViewMap.put("15",imageView15);
        imageViewMap.put("16",imageView16);
        //Row2
        imageViewMap.put("20",imageView20);
        imageViewMap.put("21",imageView21);
        imageViewMap.put("22",imageView22);
        imageViewMap.put("23",imageView23);
        imageViewMap.put("24",imageView24);
        imageViewMap.put("25",imageView25);
        imageViewMap.put("26",imageView26);
        //Row3
        imageViewMap.put("30",imageView30);
        imageViewMap.put("31",imageView31);
        imageViewMap.put("32",imageView32);
        imageViewMap.put("33",imageView33);
        imageViewMap.put("34",imageView34);
        imageViewMap.put("35",imageView35);
        imageViewMap.put("36",imageView36);
        //Row4
        imageViewMap.put("40",imageView40);
        imageViewMap.put("41",imageView41);
        imageViewMap.put("42",imageView42);
        imageViewMap.put("43",imageView43);
        imageViewMap.put("44",imageView44);
        imageViewMap.put("45",imageView45);
        imageViewMap.put("46",imageView46);
        //Row5
        imageViewMap.put("50",imageView50);
        imageViewMap.put("51",imageView51);
        imageViewMap.put("52",imageView52);
        imageViewMap.put("53",imageView53);
        imageViewMap.put("54",imageView54);
        imageViewMap.put("55",imageView55);
        imageViewMap.put("56",imageView56);

        restartButton.setVisible(false);
    }
}
