import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	JFrame window;
	Container con;
	JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleLabel, hpLabel, hpLabelNumber, manaLabel, manaLabelNumber, weaponLabel, weaponLabelString, coinLabel, coinLabelNumber, potionLabel, potionLabelNumber, lvlLabel, lvlLabelNumber, xpLabel, xpLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.BOLD, 120 );
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 18);
	Font choiceFont = new Font("Times New Roman", Font.PLAIN, 36);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainText;
	int playerLvl, playerXP, XpNeeded, playerHP, playerMana, coins, potions, rng, monsterHP, playerDMG, monsterDMG, potionHealing, oldHP, magicAffinity, magicRNG, stun, xpGained, strength, defense, magic, agility, maxHP, maxMana, potionMana, oldMana, coinsGained, x, questCoins, quest;
	String weapon, position, monster, locationMarker;
	boolean cat, princess, excalibur, dragon, demonLord, win;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		window = new JFrame();
		window.setSize(1200,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(150, 150, 900, 225);
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel("Adventure Game");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(450, 450, 300, 150);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		window.add(titlePanel);
		window.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void gameScreen() {
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(150,150,900,375);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
		mainText = new JTextArea("Intro");
		mainText.setBounds(150,150,900,375);
		mainText.setBackground(Color.black);
		mainText.setForeground(Color.white);
		mainText.setFont(normalFont);
		mainText.setLineWrap(true);
		mainText.setWrapStyleWord(true);
		mainTextPanel.add(mainText);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(75, 525, 1050, 225);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(2,2));
		window.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(choiceFont);
		choice1.setFocusPainted(false);
		choiceButtonPanel.add(choice1);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(choiceFont);
		choice2.setFocusPainted(false);
		choiceButtonPanel.add(choice2);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(choiceFont);
		choice3.setFocusPainted(false);
		choiceButtonPanel.add(choice3);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(choiceFont);
		choice4.setFocusPainted(false);
		choiceButtonPanel.add(choice4);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		
		playerPanel = new JPanel();
		playerPanel.setBounds(50,23,1100,75);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
		lvlLabel = new JLabel("Lvl:");
		lvlLabel.setFont(textFont);
		lvlLabel.setForeground(Color.white);
		lvlLabelNumber = new JLabel();
		lvlLabelNumber.setFont(textFont);
		lvlLabelNumber.setForeground(Color.white);	
		xpLabel = new JLabel("XP:");
		xpLabel.setFont(textFont);
		xpLabel.setForeground(Color.white);
		xpLabelNumber = new JLabel();
		xpLabelNumber.setFont(textFont);
		xpLabelNumber.setForeground(Color.white);	
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(textFont);
		hpLabel.setForeground(Color.white);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(textFont);
		hpLabelNumber.setForeground(Color.white);	
		manaLabel = new JLabel("Mana:");
		manaLabel.setFont(textFont);
		manaLabel.setForeground(Color.white);
		manaLabelNumber = new JLabel();
		manaLabelNumber	.setFont(textFont);
		manaLabelNumber	.setForeground(Color.white);	
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(textFont);
		weaponLabel.setForeground(Color.white);
		weaponLabelString = new JLabel();
		weaponLabelString.setFont(textFont);
		weaponLabelString.setForeground(Color.white);
		coinLabel = new JLabel("Coins:");
		coinLabel.setFont(textFont);
		coinLabel.setForeground(Color.white);
		coinLabelNumber = new JLabel();
		coinLabelNumber.setFont(textFont);
		coinLabelNumber.setForeground(Color.white);
		potionLabel = new JLabel("Potions:");
		potionLabel.setFont(textFont);
		potionLabel.setForeground(Color.white);
		potionLabelNumber = new JLabel();
		potionLabelNumber.setFont(textFont);
		potionLabelNumber.setForeground(Color.white);
		
		playerPanel.add(lvlLabel);
		playerPanel.add(lvlLabelNumber);
		playerPanel.add(xpLabel);
		playerPanel.add(xpLabelNumber);
		playerPanel.add(hpLabel);
		playerPanel.add(hpLabelNumber);
		playerPanel.add(manaLabel);
		playerPanel.add(manaLabelNumber);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponLabelString);
		playerPanel.add(coinLabel);
		playerPanel.add(coinLabelNumber);
		playerPanel.add(potionLabel);
		playerPanel.add(potionLabelNumber);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerLvl = 1;
//		playerXP = 0;
		XpNeeded = 5;
		maxHP = 20;
		playerHP = maxHP;
		maxMana = 0;
		playerMana = maxMana;
		weapon = "Knife";
//		coins = 0;
//		potions = 0;
		magicAffinity = 0;
		lvlLabelNumber.setText("" + playerLvl);
		xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
		hpLabelNumber.setText("" + playerHP);
		manaLabelNumber.setText("" + playerMana);
		weaponLabelString.setText(weapon);
		coinLabelNumber.setText("" + coins);
		potionLabelNumber.setText("" + potions);
		introductionOne();
	}
	
	public void introductionOne() {
		position = "introductionOne";
		mainText.setText("You want to join the Adventurers Guild to help defeat the Demon Lord but are not high enough level.  Go to the forest to level up.");
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void locationDecision() {
		position = "locationDecision";
		mainText.setText("Do you want to go to the Adventurers \nGuild, Shop, Forest or Inn?");	
		choice1.setText("Adventurers Guild");
		choice2.setText("Shop");
		choice3.setText("Forest");
		choice4.setText("Inn");
	}
	
	public void Inn() {
		locationMarker = "Inn";
		position = "Inn";
		mainText.setText("You have taken a rest. Your health and mana have been restored");
		playerHP = maxHP;
		hpLabelNumber.setText("" + playerHP);
		playerMana = maxMana;
		manaLabelNumber.setText("" + playerMana);
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void Shop() {
		locationMarker = "Shop";
		position = "Shop";
		mainText.setText("Merchant: Hello, please choose the item that you would like to buy");
		choice1.setText("Sword (10 coins)");
		choice2.setText("Bow (10 coins)");
		choice3.setText("Potion (2 coins)");
		choice4.setText("<--");
	}
	
	public void Sword() {
//		position = "Sword";
		if(coins>=10 && !weapon.equals("Sword")) {
			mainText.setText("Merchant: Thank you for purchasing a sword. Would you like to purchase anything else?");
			weapon = "Sword";
			weaponLabelString.setText(weapon);
			coins = coins - 10;
			coinLabelNumber.setText("" + coins);
		}
		else if (coins<2) {
			mainText.setText("Merchant: I'm sorry, you do not have enough coins to purchase a sword. Please come again when you have enough coins");
		}
		else if (weapon.equals("Sword")) {
			mainText.setText("Merchant: I'm sorry, you already have a sword");
		}
//		choice1.setText("-->");
//		choice2.setText("");
//		choice3.setText("");
//		choice4.setText("");
	}
	
	public void Bow() {
//		position = "Bow";
		if(coins>=10 && !weapon.equals("Bow")) {
			mainText.setText("Merchant: Thank you for purchasing a bow. Would you like to purchase anything else?");
			weapon = "Bow";
			weaponLabelString.setText(weapon);
			coins = coins - 10;
			coinLabelNumber.setText("" + coins);
		}
		else if (coins<2) {
			mainText.setText("Merchant: I'm sorry, you do not have enough coins to purchase a bow. Please come again when you have enough coins");
		}
		else if (weapon.equals("Bow")) {
			mainText.setText("Merchant: I'm sorry, you already have a bow");
		}
//		choice1.setText("-->");
//		choice2.setText("");
//		choice3.setText("");
//		choice4.setText("");
	}

	public void Potion() {
//		position = "Potion";
		if(coins>=2 && potions<10) {
			mainText.setText("Merchant: Thank you for purchasing a potion. Would you like to purchase anything else?");
			potions++;
			potionLabelNumber.setText("" + potions);
			coins = coins - 2;
			coinLabelNumber.setText("" + coins);
		}
		else if (coins<2) {
			mainText.setText("Merchant: I'm sorry, you do not have enough coins to purchase a potion. Please come again when you have enough coins");
		}
		else if (potions>=10) {
			mainText.setText("Merchant: I'm sorry, you have the maximum number of potions");
		}
//		choice1.setText("-->");
//		choice2.setText("");
//		choice3.setText("");
//		choice4.setText("");
	}
	
	public void lvlUpNeeded() {
		mainText.setText("You are a high enough level to join the Adventurers Guild. Please come back when you're at least level 5");
	}
	
	public void adventurersGuild() {
		locationMarker = "adventurersGuild";
		position = "adventurersGuild";
		mainText.setText("Receptionist: Hello, please choose the quest you would like to take");
		choice1.setText("Find a lost cat (Lvl 5+)");
		choice2.setText("Rescue the princess (Lvl 8+)");
		choice3.setText("<--");
		choice4.setText("-->");
	}
	public void adventurersGuild2() {
		locationMarker = "adventurersGuild";
		position = "adventurersGuild2";
		choice1.setText("Find Excalibur (Lvl 10+)");
		choice2.setText("Slay a dragon (Lvl 15+)");
		choice3.setText("Defeat the Demon Lord (Lvl 25+)");
		choice4.setText("<--");
	}
	
	public void cat() {
		position = "cat";
		quest = 1;
		questCoins = 5;
		mainText.setText("After many hours of searching you finally found the lost cat but there is a goblin guarding it. You must now fight the goblin");
		monster = "Goblin";
		monsterHP = 8;
		xpGained = 10;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	
	public void princess() {
		position = "princess";
		quest = 2;
		questCoins = 10;
		mainText.setText("After many hours of searching you finally found the princess but there is a bandit guarding her. You must now fight the bandit");
		monster = "Bandit";
		monsterHP = 15;
		xpGained = 100;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void excalibur() {
		position = "excalibur";
		quest = 3;
		questCoins = 20;
		mainText.setText("Some say that Excalibur is a legendary sword that can only be found in the forest. Go to the forest and search for Excalibur");
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void dragon() {
		position = "dragon";
		quest = 4;
		questCoins = 20;
		mainText.setText("After many hours of searching you finally found the dragon's den. You must now fight the dragon");
		monster = "Dragon";
		monsterHP = 35;
		xpGained = 300;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void demonLord() {
		position = "demonLord";
		quest = 5;
		questCoins = 100;
		mainText.setText("After many hours of searching you finally found the Demon Lord's castle. You must now fight the Demon Lord");
		monster = "Demon Lord";
		monsterHP = 70; 
		xpGained = 0;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lvlLow() {
		mainText.setText("You are too low of a level to take this quest. Please choose a different quest");
	}
	
	public void questComplete() {
		position = "questComplete";
		switch(quest) {
		case 1: cat = true; break;
		case 2: princess = true; break;
		case 3: excalibur = true; break;
		case 4: dragon = true; break;
		case 5: demonLord = true; break;
		} 
		quest = 0;
		mainText.setText("Congratulations! You completed the quest. You gained " + questCoins + " coins");
		coins = coins + questCoins;
		coinLabelNumber.setText("" + coins);
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void questInProgress() {
		mainText.setText("You are currently taking on a different quest. Please complete that quest before choosing another quest");
	}
	
	public void questDone() {
		mainText.setText("This quest has already been completed. Please choose a different quest that you have not yet completed");
	}
	
	public void forest() {
		locationMarker = "forest";
		position = "Forest";
		mainText.setText("You are at a crossroad. The left side has lower level threats while the right side has higher level threats. Which way do you want to go?");
		
		choice1.setText("Left");
		choice2.setText("Straight");
		choice3.setText("Right");
		choice4.setText("<--");
	}
	
	public void Left() {
		rng = new java.util.Random().nextInt(4);
		switch(rng) {
		case 0:
			position = "battle";
			monster = "Goblin";
			monsterHP = 8;
			xpGained = 3;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a goblin.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 1:
			position = "battle";
			monster = "Orc";
			monsterHP = 12;
			xpGained = 6;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered an orc.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 2:
			position = "battle";
			monster = "Direwolf";
			monsterHP = 10;
			xpGained = 5;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a direwolf.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 3:
			position = "Lake";
			mainText.setText("You have found a lake.  Your health and mana are now restored");
			playerHP = maxHP;
			hpLabelNumber.setText("" + playerHP);
			playerMana = maxMana;
			manaLabelNumber.setText("" + playerMana);
			
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			break;
		}
	}
	
	public void Straight() {
		if(magicAffinity == 1) {
			x = 3;
		}
		else {
			x = 4;
		}
		rng = new java.util.Random().nextInt(x);
		switch(rng) {
		case 0:
			position = "battle";
			monster = "Ogre";
			monsterHP = 15;
			xpGained = 10;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered an Ogre.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 1:
			position = "battle";
			monster = "Harpy";
			monsterHP = 14;
			xpGained = 12;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a Harpy.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 2:
			position = "battle";
			monster = "Minotaur";
			monsterHP = 16;
			xpGained = 14;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a Minotaur.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 3:
			position = "Elemental";
			mainText.setText("You have found an elemental spirit. You can now use magic");
			magicAffinity = 1;
			maxMana = 20;
			playerMana = maxMana;
			manaLabelNumber.setText("" + playerMana);
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			break;
		}
	}
	
	public void Right() {
		rng = new java.util.Random().nextInt(4);
		switch(rng) {
		case 0:
			position = "battle";
			monster = "Wyvern";
			monsterHP = 30;
			xpGained = 50;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a Wyvern.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 1:
			position = "battle";
			monster = "Archdemon";
			monsterHP = 25;
			xpGained = 40;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered an Archdemon.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 2:
			position = "battle";
			monster = "Vampire";
			monsterHP = 21;
			xpGained = 35;
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a Vampire.  What will you do?");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
			break;
		case 3:
			position = "Treasure";
			x = 2;
			if(quest == 3){
				x = 3;
			}
			rng = new java.util.Random().nextInt(x);
			if(rng == 2) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and found Excalibur");
				weapon = "Excalibur";
				weaponLabelString.setText(weapon);
			}
			if(rng == 1) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and found 50 coins");
				coins = coins + 50;
				coinLabelNumber.setText("" + coins);
			}
			if(rng == 1) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and got 100 xp");
				playerXP = playerXP + 100;
				xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
			}
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			break;
		}
	}
	
	public void Fight() {
		position = "Fight";
		mainText.setText(monster + " HP: " + monsterHP + "\nWhat will you do?");
		choice1.setText("Use weapon");
		choice2.setText("Use magic");
		choice3.setText("Drink a potion");
		choice4.setText("Run");
	}
	
	public void useWeapon() {
		position = "useWeapon";
		if(weapon.equals("Knife")) {
			playerDMG = new java.util.Random().nextInt(3);
			playerDMG++;
			playerDMG = playerDMG + strength;
		}
		else if(weapon.equals("Sword")) {
			playerDMG = new java.util.Random().nextInt(5);
			playerDMG++;
			playerDMG = playerDMG + strength;
		}
		else if(weapon.equals("Bow")) {
			playerDMG = new java.util.Random().nextInt(5);
			playerDMG++;
			playerDMG = playerDMG + strength;
		}
		else if(weapon.equals("Excalibur")) {
			playerDMG = new java.util.Random().nextInt(10);
			playerDMG++;
			playerDMG = playerDMG + strength;
		}
		mainText.setText("You attacked the " + monster + " with your " + weapon + " and did " + playerDMG + " damage");
		monsterHP = monsterHP - playerDMG;
		if(monsterHP<0) {
			monsterHP = 0;
		}
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void useMagic() {
		position = "useMagic";
		if(magicAffinity == 0) {
			mainText.setText("Sorry, you do not have an affinity for magic.  Find an elemental spirit to learn magic");
			
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			mainText.setText("Which magic ability would you like to use?");
		choice1.setText("Fire Magic");
		choice2.setText("Ice Magic");
		choice3.setText("Poison Magic");
		choice4.setText("Lightning Magic");
		}
	}
	
	public void Fire() {
		position = "Fire";
		playerMana = playerMana - 3;
		if(playerMana>=0) {
			manaLabelNumber.setText("" + playerMana);
			rng = new java.util.Random().nextInt(3);
		playerDMG = new java.util.Random().nextInt(5);
		playerDMG++;
		playerDMG = playerDMG + magic;
		monsterHP = monsterHP - playerDMG;
		if(monsterHP<0) {
			monsterHP = 0;
		}
		if(rng == 0 && monsterHP > 0) {
			magicRNG = new java.util.Random().nextInt(2);
			magicRNG++;
			mainText.setText("You attacked the " + monster + " with fire magic and did " + playerDMG + " damage. You managed to burn the " + monster + " and did an additional " + magicRNG + " damage");
		}
		else {
			mainText.setText("You attacked the " + monster + " with fire magic and did " + playerDMG + " damage");
		}
		playerDMG = playerDMG + magicRNG;	
		magicRNG = 0;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "Fight";
			mainText.setText("You don't have enough mana. Please choose a different move");
			choice1.setText("Use weapon");
			choice2.setText("Use magic");
			choice3.setText("Drink a potion");
			choice4.setText("Run");
		}
	}
	
	public void Ice() {
		position = "Ice";
		playerMana = playerMana - 3;
		if(playerMana>=0) {
		manaLabelNumber.setText("" + playerMana);
		rng = new java.util.Random().nextInt(3);
		playerDMG = new java.util.Random().nextInt(5);
		playerDMG++;
		playerDMG = playerDMG + magic;
		monsterHP = monsterHP - playerDMG;
		if(monsterHP<0) {
			monsterHP = 0;
		}
		if(rng == 0 && monsterHP > 0) {
			stun = 1;
			mainText.setText("You attacked the " + monster + " with ice magic and did " + playerDMG + " damage. You managed to freeze the " + monster + " for one turn");
		}
		else {
			mainText.setText("You attacked the " + monster + " with ice magic and did " + playerDMG + " damage");
		}
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "Fight";
			mainText.setText("You don't have enough mana. Please choose a different move");
			choice1.setText("Use weapon");
			choice2.setText("Use magic");
			choice3.setText("Drink a potion");
			choice4.setText("Run");
		}
	}
	
	public void Poison() {
		position = "Poison";
		playerMana = playerMana - 3;
		if(playerMana>=0) {
		manaLabelNumber.setText("" + playerMana);
		rng = new java.util.Random().nextInt(3);
		playerDMG = new java.util.Random().nextInt(5);
		playerDMG++;
		monsterHP = monsterHP - playerDMG;
		if(monsterHP<0) {
			monsterHP = 0;
		}
		if(rng == 0 && monsterHP > 0) {
			magicRNG = new java.util.Random().nextInt(2);
			magicRNG++;
			mainText.setText("You attacked the " + monster + " with poison magic and did " + playerDMG + " damage. You managed to poison the " + monster + " and did an additional " + magicRNG + " damage");
		}
		else {
			mainText.setText("You attacked the " + monster + " with poison magic and did " + playerDMG + " damage");
		}
		playerDMG = playerDMG + magicRNG;
		magicRNG = 0;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "Fight";
			mainText.setText("You don't have enough mana. Please choose a different move");
			choice1.setText("Use weapon");
			choice2.setText("Use magic");
			choice3.setText("Drink a potion");
			choice4.setText("Run");
		}
	}
	
	public void Lightning() {
		position = "Lightning";
		playerMana = playerMana - 3;
		if(playerMana>=0) {
		manaLabelNumber.setText("" + playerMana);
		rng = new java.util.Random().nextInt(3);
		playerDMG = new java.util.Random().nextInt(5);
		playerDMG++;
		playerDMG = playerDMG + magic;
		monsterHP = monsterHP - playerDMG;
		if(monsterHP<0) {
			monsterHP = 0;
		}
		if(rng == 0 && monsterHP > 0) {
			stun = 1;
			mainText.setText("You attacked the " + monster + " with lightning magic and did " + playerDMG + " damage. You managed to stun the " + monster + " for one turn");
		}
		else {
			mainText.setText("You attacked the " + monster + " with lightning magic and did " + playerDMG + " damage");
		}
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "Fight";
			mainText.setText("You don't have enough mana. Please choose a different move");
			choice1.setText("Use weapon");
			choice2.setText("Use magic");
			choice3.setText("Drink a potion");
			choice4.setText("Run");
		}
	}
	
	public void drinkPotion() {
		position = "drinkPotion";
		if(potions > 0) {
		potions = potions - 1;
		potionHealing = new java.util.Random().nextInt(5);
		potionHealing++;
		potionHealing = potionHealing + (playerLvl/4);
		oldHP = playerHP;
		playerHP = playerHP + potionHealing;
		if(playerHP>maxHP) {
			playerHP = maxHP;
			potionHealing = playerHP - oldHP;
		}
		potionMana = new java.util.Random().nextInt(5);
		potionMana++;
		potionMana = potionMana + (playerLvl/4);
		oldMana = playerMana;
		playerMana = playerMana + potionMana;
		if(playerMana>maxMana) {
			playerMana = maxMana;
			potionMana = playerMana - oldMana;
		}
		hpLabelNumber.setText("" + playerHP);
		manaLabelNumber.setText("" + playerMana);
		mainText.setText("You gained " + potionHealing + " HP and " + potionMana + " mana");
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "Fight";
			mainText.setText("You do not have any potions. Please choose another move");
			choice1.setText("Use weapon");
			choice2.setText("Use magic");
			choice3.setText("Drink a potion");
			choice4.setText("Run");
		}
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		if(monster.equals("Goblin")) {
			monsterDMG = new java.util.Random().nextInt(2);
			monsterDMG++;
		}
		else if(monster.equals("Orc")) {
			monsterDMG = new java.util.Random().nextInt(4);
			monsterDMG++;
		}
		else if(monster.equals("Direwolf")) {
			monsterDMG = new java.util.Random().nextInt(3);
			monsterDMG++;
		}
		else if(monster.equals("Ogre")) {
			monsterDMG = new java.util.Random().nextInt(4);
			monsterDMG = monsterDMG + 2;
		}
		else if(monster.equals("Harpy")) {
			monsterDMG = new java.util.Random().nextInt(3);
			monsterDMG = monsterDMG + 2;
		}
		else if(monster.equals("Minotaur")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 2;
		}
		else if(monster.equals("Bandit")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 2;
		}
		else if(monster.equals("Wyvern")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 4;
		}
		else if(monster.equals("Archdemon")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 3;
		}
		else if(monster.equals("Vampire")) {
			monsterDMG = new java.util.Random().nextInt(3);
			monsterDMG = monsterDMG + 3;
		}
		else if(monster.equals("Dragon")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 4;
		}
		else if(monster.equals("Demon Lord")) {
			monsterDMG = new java.util.Random().nextInt(5);
			monsterDMG = monsterDMG + 6;
		}
		if(monster.equals("Vampire")) {
			mainText.setText("The " + monster + " attacked you and did " + monsterDMG + " damage and gained 1 HP");
			monsterHP++;
		}
		else {
			mainText.setText("The " + monster + " attacked you and did " + monsterDMG + " damage");
		}
		playerHP = playerHP - monsterDMG;
		if(playerHP<0) {
			playerHP = 0;
		}
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void Run() {
		rng = new java.util.Random().nextInt(100);
		rng++;
		if(rng < (50 + (agility * 3))) {
			position = "Run";
			mainText.setText("You have successfully ran away.");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "failedRun";
			mainText.setText("You have failed to run away. \nLevel up agility to increase your chances of escaping");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	}
	
	public void forestContinue() {
		position = "forestContinue";
		mainText.setText("Would you like to continue exploring?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lose() {
		position = "lose";
		mainText.setText("You are dead! \n\n\n <GAME OVER>");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void win() {
		position = "win";
		mainText.setText("Congratulations, you have defeated the Demon Lord \n\n\n <YOU WIN>");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void monsterKilled() {
		position = "monsterKilled";
		switch(monster) {
		case "Goblin": 
			coinsGained = 1; break;
		case "Orc": 
			coinsGained = 1; break;
		case "Direwolf": 
			coinsGained = 1; break;
		case "Ogre": 
			coinsGained = 2; break;
		case "Harpy": 
			coinsGained = 2; break;
		case "Minotaur": 
			coinsGained = 2; break;
		case "Bandit": 
			coinsGained = 3; break;
		case "Wyvern": 
			coinsGained = 4; break;
		case "Archdemon": 
			coinsGained = 3; break;
		case "Vampire": 
			coinsGained = 3; break;
		case "Dragon":
			coinsGained = 10; break;
		case "Demon Lord":
			coinsGained = 50; 
			win = true; break;
		}
		playerXP = playerXP + xpGained;
		xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
		coins = coins + coinsGained;
		coinLabelNumber.setText("" + coins);
		mainText.setText(monster + " HP: " + monsterHP + "\nCongratulations, you have killed the " + monster + ". You gained " + coinsGained + " coins and " + xpGained + " XP");
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lvlUp() {
		playerLvl++;
		playerXP = playerXP - XpNeeded;
		XpNeeded = (int) (XpNeeded * 1.2);
		lvlLabelNumber.setText("" + playerLvl);
		xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
		hpLabelNumber.setText("" + playerHP);
		if(playerLvl < 40) {
			position = "lvlUp";
		mainText.setText("Congratulations!  You leveled up! \nPlease choose the category you want to level up. \nStrength: " + strength + "              Defense: " + defense + "\nMagic: " + magic + "                 Agility: " + agility);
		choice1.setText("Strength");
		choice2.setText("Defense");
		choice3.setText("Magic");
		choice4.setText("Agility");
		}
		else {
			if(locationMarker.equals("Forest")) {
				forestContinue();
			}
			else {
				questComplete();
			}
		}
	}
	
	public void lvlUpRedo() {
		position = "lvlUpRedo";
		mainText.setText("Please choose the category you want to level up. \nStrength: " + strength + "              Defense: " + defense + "\nMagic: " + magic + "                 Agility: " + agility);
		choice1.setText("Strength");
		choice2.setText("Defense");
		choice3.setText("Magic");
		choice4.setText("Agility");
	}
	
	public void Strength() {
		if(strength < 10) {
			position = "Strength";
			mainText.setText("Congratulations!  You leveled up Strength");
			strength++;
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "maxLvl";
			mainText.setText("You have already maxed out your strength. Please choose a different category to level up");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	}
	
	public void Defense() {
		if(defense < 10) {
			position = "Defense";
			mainText.setText("Congratulations!  You leveled up Defense");
			defense++;
			maxHP = 20 + defense;
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "maxLvl";
			mainText.setText("You have already maxed out your defense. Please choose a different category to level up");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	}
	
	public void Magic() {
		if(magic < 10) {
		if(magicAffinity == 1) {
		position = "Magic";
		mainText.setText("Congratulations!  You leveled up Magic");
		magic++;
		maxMana = 20 + magic;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "noMagicAffinity";
			mainText.setText("You do not have an affinity for magic. Please choose another category to level up");
			choice1.setText("Strength");
			choice2.setText("Defense");
			choice3.setText("Agility");
			choice4.setText("");
		}
		}
		else {
			position = "maxLvl";
			mainText.setText("You have already maxed out your magic. Please choose a different category to level up");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	}
	
	public void Agility() {
		if(magic < 10) {
		position = "Agility";
		mainText.setText("Congratulations!  You leveled up Agility");
		agility++;
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
		else {
			position = "maxLvl";
			mainText.setText("You have already maxed out your agility. Please choose a different category to level up");
			choice1.setText("-->");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			gameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{	
		public void actionPerformed(ActionEvent event) {
			String Choice = event.getActionCommand();
			switch(position) {
			case "introductionOne":
				switch(Choice) {
				case "c1": locationDecision(); break;
				}
				break;
			case "locationDecision":
				switch(Choice) {
				case "c1": 
					if(playerLvl < 5) {
						lvlUpNeeded();
					}
					else {
						adventurersGuild();
					}
					break;
				case "c2": Shop(); break;
				case "c3": forest(); break;
				case "c4": Inn();
				}
				break;
			case "adventurersGuild":
				switch (Choice) {
				case "c1": 
					if(playerLvl < 5) {
						lvlLow();
					}
					else {
						if(quest == 0 || quest == 1) {
						if(cat == false) {
							cat(); 
						} 
						else {
							questDone();
						}
					}
					else {
						questInProgress();
					} }
					break;
				case "c2": 
					if(playerLvl < 8) {
						lvlLow();
					}
					else {
					if(quest == 0 || quest == 2) {
						if(princess == false) {
							princess(); 
						} 
						else {
							questDone();
						}
					}
					else {
						questInProgress();
					} }
					break;
				case "c3": locationDecision(); break;
				case "c4": adventurersGuild2(); break;
				}
				break;
			case "adventurersGuild2":
				switch (Choice) {
				case "c1": 
					if(playerLvl < 10) {
						lvlLow();
					}
					else {
					if(quest == 0 || quest == 3) {
						if(excalibur == false) {
							excalibur(); 
						} 
						else {
							questDone();
						}
					}
					else {
						questInProgress();
					} }
					break;
				case "c2": 
					if(playerLvl < 15) {
						lvlLow();
					}
					else {
					if(quest == 0 || quest == 4) {
						if(dragon == false) {
							dragon(); 
						} 
						else {
							questDone();
						}
					}
					else {
						questInProgress();
					} }
					break;
				case "c3": 
					if(playerLvl < 25) {
						lvlLow();
					}
					else {
					if(quest == 0 || quest == 5) {
						if(demonLord == false) {
							demonLord(); 
						} 
						else {
							questDone();
						}
					}
					else {
						questInProgress();
					} }
					break;
				case "c4": locationDecision(); break;
				}
				break;
			case "cat":
				switch(Choice) {
				case "c1": Fight(); break;
				}
				break;
			case "princess":
				switch(Choice) {
				case "c1": Fight(); break;
				}
				break;
			case "excalibur":
				switch(Choice) {
				case "c1": forest(); break;
				}
				break;
			case "dragon":
				switch(Choice) {
				case "c1": Fight(); break;
				}
				break;
			case "demonLord":
				switch(Choice) {
				case "c1": Fight(); break;
				}
				break;
			case "questComplete":
				switch(Choice) {
				case "c1": 
					if(win == false) {
						locationDecision(); 
					}
					else {
						win();
					}
					break;
				}
				break;
			case "Inn":
				switch(Choice) {
				case "c1": locationDecision(); break;
				}
				break;
			case "Shop":
				switch(Choice) {
				case "c1": Sword(); break;
				case "c2": Bow(); break;
				case "c3": Potion(); break;
				case "c4": locationDecision(); break;
				}
				break;
//			case "Sword":
//				switch(Choice) {
//				case "c1": locationDecision(); break;
//				}
//				break;
//			case "Bow":
//				switch(Choice) {
//				case "c1": locationDecision(); break;
//				}
//				break;
//			case "Potion":
//				switch(Choice) {
//				case "c1": locationDecision(); break;
//				}
//				break;
			case "Forest":
				switch(Choice) {
				case "c1": Left(); break;
				case "c2": Straight(); break;
				case "c3": Right(); break;
				case "c4": locationDecision(); break;
				}
				break;
			case "battle":
				switch(Choice) {
				case "c1": Fight(); break;
				case "c2": Run(); break;
				}
				break;
			case "Lake":
				switch(Choice) {
				case "c1": forestContinue(); break;
				}
				break;
			case "Run":
				switch(Choice) {
				case "c1": 
					if(locationMarker.equals("forest")){
						forestContinue(); break;
					}
					else {
						locationDecision(); break;
					}
				}
				break;
			case "forestContinue":
				switch(Choice) {
				case "c1": forest(); break;
				case "c2": locationDecision(); break;
				}
				break;
			case "Fight":
				switch(Choice) {	
				case "c1": useWeapon(); break;
				case "c2": useMagic(); break;
				case "c3": drinkPotion(); break;
				case "c4": Run(); break;
				}
				break;
			case "useWeapon":
				switch(Choice) {
				case "c1": 
					if(monsterHP<=0) {
						monsterKilled();
					}
					else{
						monsterAttack(); break;
					}
				}
				break;
			case "monsterAttack":
				switch(Choice) {
				case "c1": 
					if(playerHP<=0) {
						lose();
					}
					else{
						Fight(); break;
					}
				}
				break;
			case "monsterKilled":
				switch(Choice) {
				case "c1": 
						if(playerXP >= XpNeeded) {
							lvlUp(); break;
						}
						else if(locationMarker.equals("forest")){
							forestContinue(); break;
						}
						else {
							questComplete(); break;
						}
				}
				break;
			case "drinkPotion":
				switch(Choice) {
				case "c1": monsterAttack(); break;
				}
				break;
			case "useMagic":
				if(magicAffinity == 0) {
					switch(Choice) {
					case "c1": Fight(); break;
					}
				}
				else  {
					switch(Choice) {
					case "c1": 
						if(monsterHP<=0) {
							monsterKilled();
						}
						else{
							Fire(); break;
						}
					case "c2": 
						if(monsterHP<=0) {
							monsterKilled();
						}
						else{
							Ice(); break;
						}
					case "c3": 
						if(monsterHP<=0) {
							monsterKilled();
						}
						else{
							Poison(); break;
						}
					case "c4": 
						if(monsterHP<=0) {
							monsterKilled();
						}
						else{
							Lightning(); break;
						}
				}
				break;
				}
				break;
			case "Fire":
				switch(Choice) {
				case "c1": 
					if(monsterHP<=0) {
						monsterKilled();
					}
					else{
						monsterAttack(); break;
					}
				}
				break;
			case "Ice":
				switch(Choice) {
				case "c1": 
					if(monsterHP<=0) {
						monsterKilled();
					}
					else if(stun == 1) {
						Fight(); stun = 0; break;
					}
					else{
						monsterAttack(); break;
					}
				}
				break;
			case "Poison":
				switch(Choice) {
				case "c1": 
					if(monsterHP<=0) {
						monsterKilled();
					}
					else{
						monsterAttack(); break;
					}
				}
				break;
			case "Lightning":
				switch(Choice) {
				case "c1": 
					if(monsterHP<=0) {
						monsterKilled();
					}
					else if(stun == 1) {
						Fight(); stun = 0; break;
					}
					else{
						monsterAttack(); break;
					}
				}
				break;
			case "Elemental":
				switch(Choice) {
				case "c1": forestContinue(); break;
				}
				break;
			case "Treasure":
				switch(Choice) {
				case "c1": 
					if(playerLvl < 40) {
						if(playerXP >= XpNeeded) {
							lvlUp(); break;
						}
						else if(weapon.equals("Excalibur") && quest == 3) {
							questComplete(); break;
						}
						else {
							forestContinue(); break;
						}
					}
					else if(weapon.equals("Excalibur") && quest == 3) {
						questComplete(); break;
					}
					else {
						forestContinue(); break;
					}
				}
				break;
			case "lvlUp":
				switch(Choice) {
				case "c1": Strength(); break;
				case "c2": Defense(); break;
				case "c3": Magic(); break;
				case "c4": Agility(); break;
				}
				break;
			case "Strength":
				switch(Choice) {
				case "c1":
					if(playerXP >= XpNeeded) {
						lvlUp(); break;
					}
					else if(locationMarker.equals("forest")){
						forestContinue(); break;
					}
					else {
						questComplete(); break;
					}
				}
				break;
			case "Defense":
				switch(Choice) {
				case "c1":
					if(playerXP >= XpNeeded) {
						lvlUp(); break;
					}
					else if(locationMarker.equals("forest")){
						forestContinue(); break;
					}
					else {
						questComplete(); break;
					}
				}
				break;
			case "Magic":
				switch(Choice) {
				case "c1":
					if(playerXP >= XpNeeded) {
						lvlUp(); break;
					}
					else if(locationMarker.equals("forest")){
						forestContinue(); break;
					}
					else {
						questComplete(); break;
					}
				}
				break;
			case "Agility":
				switch(Choice) {
				case "c1":
					if(playerXP >= XpNeeded) {
						lvlUp(); break;
					}
					else if(locationMarker.equals("forest")){
						forestContinue(); break;
					}
					else {
						questComplete(); break;
					}
				}
				break;
			case "noMagicAffinity":
				switch(Choice) {
				case "c1": Strength(); break;
				case "c2": Defense(); break;
				case "c3": Agility(); break;
				}
				break;
			case "failedRun":
				switch(Choice) {
				case "c1": monsterAttack(); break;
				}
				break;
			case "maxLvl":
				switch(Choice) {
				case "c1": lvlUpRedo(); break;
				}
				break;
			case "lvlUpRedo":
				switch(Choice) {
				case "c1": Strength(); break;
				case "c2": Defense(); break;
				case "c3": Magic(); break;
				case "c4": Agility(); break;
				}
				break;
			}
		}
	}
}
