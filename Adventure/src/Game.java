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
	int playerLvl, playerXP, XpNeeded, playerHP, playerMana, coins, potions, rng, monsterHP, playerDMG, monsterDMG, potionHealing, oldHP, magicAffinity, magicRNG, stun, xpGained, strength, defense, magic, agility, maxHP, maxMana, potionMana, oldMana, coinsGained, x, y, questCoins, quest, categoryLvl, lvlRequired, i, magicNumber, baseDMG, randomDMG, coinsNeeded;
	String weapon, position, monster, locationMarker, category, hurt, magicType, item;
	boolean cat, princess, excalibur, dragon, demonLord, win, killed;
	Boolean[] booleanArray = new Boolean[6];
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
		choiceButtonPanel.setLayout(new GridLayout(2,2));
		window.add(choiceButtonPanel);
		
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(choiceFont);
		choice1.setFocusPainted(false);
		choiceButtonPanel.add(choice1);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(choiceFont);
		choice2.setFocusPainted(false);
		choiceButtonPanel.add(choice2);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choice3 = new JButton();
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(choiceFont);
		choice3.setFocusPainted(false);
		choiceButtonPanel.add(choice3);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choice4 = new JButton();
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
		XpNeeded = 5;
		maxHP = 20;
		playerHP = maxHP;
		weapon = "Knife";
		quest = 5;
		for(int i=0; i<5; i++) {
			booleanArray[i] = false;
		}
		lvlLabelNumber.setText("" + playerLvl);
		xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
		hpLabelNumber.setText("" + playerHP);
		manaLabelNumber.setText("" + playerMana);
		weaponLabelString.setText(weapon);
		coinLabelNumber.setText("" + coins);
		potionLabelNumber.setText("" + potions);
		introductionOne();
	}
	
	public void continueButton() {
		choice1.setText("-->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void introductionOne() {
		position = "introductionOne";
		mainText.setText("You want to join the Adventurers Guild to help defeat the Demon Lord but are not high enough level.  Go to the forest to level up.");
		continueButton();
	}
	
	public void locationDecision() {
		position = "locationDecision";
		killed = false;
		mainText.setText("Do you want to go to the Adventurers Guild, Shop, Forest or Inn?");	
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
		continueButton();
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
	
	public void Items() {
		if(coins>=coinsNeeded) {
			if(weapon.equals(item)) {
				mainText.setText("Merchant: I'm sorry, you already have a " + weapon + ". Please choose a different item to purchase");
			}
			else {
				switch(item) {
			case "Sword": weapon = "Sword"; break;
			case "Bow": weapon = "Bow"; break;
			case "Potion": potions++; break;
				}
			potionLabelNumber.setText("" + potions);
			coins = coins - coinsNeeded;
			coinLabelNumber.setText("" + coins);
			weaponLabelString.setText(weapon);
			mainText.setText("Merchant: Thank you for purchasing a " + item + ". Would you like to purchase anything else?");
			}	
		}
		else {
			mainText.setText("Merchant: I'm sorry, you do not have enough coins to purchase this item. Please come again when you have enough coins");
		}
	}
	
	public void lvlUpNeeded() {
		mainText.setText("You are not high enough level to join the Adventurers Guild. Please come back when you're at least level 5");
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
	
	public void quest() {
		if(playerLvl < lvlRequired) {
			lvlLow();
		}
		else if(quest == 5 || quest == i) {
			if(booleanArray[i]) {
				questDone();
			}
			else {
				switch(i) {
				case 0: 
					mainText.setText("After many hours of searching you finally found the lost cat but there is a goblin guarding it. You must now fight the goblin");
					position = "battle"; 
					quest = 0; 
					questCoins = 5; 
					monster = "Goblin"; 
					monsterHP = 8;
					xpGained = 10; 
					coinsGained = 1; 
					baseDMG = 1; 
					randomDMG = 2; 
					fightOrRun(); break;
				case 1: 
					mainText.setText("After many hours of searching you finally found the princess but there is a bandit guarding her. You must now fight the bandit");
					position = "battle"; 
					quest = 1; 
					questCoins = 10; 
					monster = "Bandit"; 
					monsterHP = 15;
					xpGained = 100; 
					coinsGained = 3; 
					baseDMG = 2; 
					randomDMG = 5; 
					fightOrRun(); break;
				case 2: 
					mainText.setText("Some say that Excalibur is a legendary sword that can only be found in the forest. Go to the forest and search for Excalibur");
					position = "forestContinue"; 
					quest = 2; 
					questCoins = 20; 
					choice2.setText("<--"); 
					continueButton(); break;
				case 3: 
					mainText.setText("After many hours of searching you finally found the dragon's den. You must now fight the dragon");
					position = "battle"; 
					quest = 3; 
					questCoins = 20; 
					monster = "Dragon"; 
					monsterHP = 35;
					xpGained = 300; 
					coinsGained = 10; 
					baseDMG = 4; 
					randomDMG = 5; 
					fightOrRun(); break;
				case 4: 
					mainText.setText("After many hours of searching you finally found the Demon Lord's castle. You must now fight the Demon Lord");
					position = "battle"; 
					quest = 4; 
					questCoins = 100; 
					monster = "Demon Lord"; 
					monsterHP = 70; 
					baseDMG = 6; 
					randomDMG = 5; 
					fightOrRun(); break;
				}
			}
		}
		else {
			questInProgress();
		}
	}
	
	public void lvlLow() {
		mainText.setText("You are too low of a level to take this quest. Please choose a different quest");
	}
	
	public void questComplete() {
		position = "questComplete";
		booleanArray[quest] = true;
		switch(quest) {
		case 0: cat = true; break;
		case 1: princess = true; break;
		case 2: excalibur = true; break;
		case 3: dragon = true; break;
		case 4: demonLord = true; break;
		} 
		quest = 5;
		mainText.setText("Congratulations! You completed the quest. You gained " + questCoins + " coins");
		coins = coins + questCoins;
		coinLabelNumber.setText("" + coins);
		continueButton();
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
	
	public void fightOrRun() {
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void Left() {
		coinsGained = 1;
		rng = new java.util.Random().nextInt(4);
		switch(rng) {
		case 0: monster = "Goblin"; monsterHP = 8; xpGained = 3; randomDMG = 2; break;
		case 1: monster = "Orc"; monsterHP = 12; xpGained = 6; randomDMG = 4; break;
		case 2: monster = "Direwolf"; monsterHP = 10; xpGained = 5; randomDMG = 3; break;
		}
		baseDMG = 1;
		position = "battle";
		if(rng == 3) {
			position = "Lake";
			mainText.setText("You have found a lake.  Your health and mana are now restored");
			playerHP = maxHP;
			hpLabelNumber.setText("" + playerHP);
			playerMana = maxMana;
			manaLabelNumber.setText("" + playerMana);
			continueButton();
		}
		else {
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a " + monster + ".  What will you do?");
			fightOrRun();
		}
		
	}
	
	public void Straight() {
		coinsGained = 2;
		switch(magicAffinity) {
		case 0: x = 4; break;
		case 1: x = 3; break;
		}
		rng = new java.util.Random().nextInt(x);
		switch(rng) {
		case 0: monster = "Ogre"; monsterHP = 15; xpGained = 10; randomDMG = 4; break;
		case 1: monster = "Harpy"; monsterHP = 14; xpGained = 12; randomDMG = 3; break;
		case 2: monster = "Minotaur"; monsterHP = 16; xpGained = 14; randomDMG = 5; break;
		}
		baseDMG = 2;
		position = "battle";
		if(rng == 3) {
			position = "Elemental";
			mainText.setText("You have found an elemental spirit. You can now use magic");
			magicAffinity = 1;
			maxMana = 20;
			playerMana = maxMana;
			manaLabelNumber.setText("" + playerMana);
			continueButton();
		}
		else {
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a " + monster + ".  What will you do?");
			fightOrRun();
		}
	}
	
	public void Right() {
		coinsGained = 3;
		rng = new java.util.Random().nextInt(4);
		switch(rng) {
		case 0: monster = "Wyvern"; monsterHP = 30; xpGained = 50; randomDMG = 5; break;
		case 1: monster = "Archdemon"; monsterHP = 25; xpGained = 40; randomDMG = 5; break;
		case 2: monster = "Vampire"; monsterHP = 21; xpGained = 35; randomDMG = 3; break;
		}
		baseDMG = 3;
		position = "battle";
		if(rng == 3) {
			position = "Treasure";
			x = 2;
			if(quest == 2){
				x = 3;
			}
			rng = new java.util.Random().nextInt(x);
			if(rng == 0) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and got 100 xp");
				playerXP = playerXP + 100;
				xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
			}
			else if(rng == 1) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and found 50 coins");
				coins = coins + 50;
				coinLabelNumber.setText("" + coins);
			}
			else if(rng == 2) {
				mainText.setText("Congratulations! You have found a treasure chest. You opened it and found Excalibur");
				weapon = "Excalibur";
				weaponLabelString.setText(weapon);
			}
			continueButton();
		}
		else {
			mainText.setText(monster + " HP: " + monsterHP + "\nYou have encountered a " + monster + ".  What will you do?");
			fightOrRun();
		}
	}
	
	public void fightChoice() {
		choice1.setText("Use weapon");
		choice2.setText("Use magic");
		choice3.setText("Drink a potion");
		choice4.setText("Run");
	}
	
	public void Fight() {
		position = "Fight";
		mainText.setText(monster + " HP: " + monsterHP + "\nWhat will you do?");
		fightChoice();
	}
	
	public void monsterHpLow() {
		if(monsterHP<0) {
			monsterHP = 0;
		}
	}
	
	public void useWeapon() {
		position = "attack";
		if(weapon.equals("Knife")) {
			playerDMG = new java.util.Random().nextInt(3) + 1 + strength;
		}
		else if(weapon.equals("Sword")) {
			playerDMG = new java.util.Random().nextInt(5) + 1 + strength;
		}
		else if(weapon.equals("Bow")) {
			playerDMG = new java.util.Random().nextInt(5) + 1 + strength;		
		}
		else if(weapon.equals("Excalibur")) {
			playerDMG = new java.util.Random().nextInt(10) + 1 + strength;
		}
		mainText.setText("You attacked the " + monster + " with your " + weapon + " and did " + playerDMG + " damage");
		monsterHP = monsterHP - playerDMG;
		monsterHpLow();
		continueButton();
	}
	
	public void useMagic() {
		position = "useMagic";
		if(magicAffinity == 0) {
			mainText.setText("Sorry, you do not have an affinity for magic. Find an elemental spirit to learn magic");
			continueButton();
		}
		else {
			mainText.setText("Which magic ability would you like to use?");
			choice1.setText("Fire Magic");
			choice2.setText("Ice Magic");
			choice3.setText("Poison Magic");
			choice4.setText("Lightning Magic");
		}
	}
	
	public void noMana() {
		position = "Fight";
		mainText.setText("You don't have enough mana. Please choose a different move");
		fightChoice();
	}
	
	public void magicAttack(){
		position = "attack";	
		if(playerMana>=3) {
			playerMana = playerMana - 3;
			manaLabelNumber.setText("" + playerMana);
			rng = new java.util.Random().nextInt(3);
			playerDMG = new java.util.Random().nextInt(5) + 1 + magic;
			monsterHP = monsterHP - playerDMG;
			monsterHpLow();
			switch(magicNumber) {
			case 1: hurt = "burn"; magicType = "fire"; break;
			case 2: hurt = "freeze"; magicType = "ice"; break;
			case 3: hurt = "poison"; magicType = "poison"; break;
			case 4: hurt = "stun"; magicType = "lightning"; break;
		}
		if(rng == 0 && monsterHP > 0) {
			if(magicNumber % 2 == 1) {
				magicRNG = new java.util.Random().nextInt(2) + 1;
				mainText.setText("You attacked the " + monster + " with " + magicType + " magic and did " + playerDMG + " damage. You managed to " + hurt + " the " + monster + " and did an additional " + magicRNG + " damage");
			}
			else {
				stun = 1;
				mainText.setText("You attacked the " + monster + " with " + magicType + " magic and did " + playerDMG + " damage. You managed to " + hurt + " the " + monster + " for one turn");
			}
		}
		else {
			mainText.setText("You attacked the " + monster + " with " + magicType + " magic and did " + playerDMG + " damage");
		}
		playerDMG = playerDMG + magicRNG;	
		magicRNG = 0;
		continueButton();
		}
		else {
			noMana();
		}
	}
	
	public void drinkPotion() {
		position = "drinkPotion";
		if(potions > 0) {
			potions = potions - 1;
			potionHealing = new java.util.Random().nextInt(5) + 1 + (playerLvl/4);
			oldHP = playerHP;
			playerHP = playerHP + potionHealing;
		if(playerHP>maxHP) {
			playerHP = maxHP;
			potionHealing = playerHP - oldHP;
		}
		potionMana = new java.util.Random().nextInt(5) + 1 + (playerLvl/4);
		oldMana = playerMana;
		playerMana = playerMana + potionMana;
		if(playerMana>maxMana) {
			playerMana = maxMana;
			potionMana = playerMana - oldMana;
		}
		hpLabelNumber.setText("" + playerHP);
		manaLabelNumber.setText("" + playerMana);
		mainText.setText("You gained " + potionHealing + " HP and " + potionMana + " mana");
		continueButton();
		}
		else {
			position = "Fight";
			mainText.setText("You do not have any potions. Please choose another move");
			fightChoice();
		}
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		if(monsterHP<=0) {
			monsterKilled();
		}
		else if(stun == 1) {
			Fight(); 
			stun = 0;
		}
		else {
		monsterDMG = new java.util.Random().nextInt(randomDMG) + baseDMG;
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
		continueButton();
		}
	}
	
	public void Run() {
		rng = new java.util.Random().nextInt(100) + 1;
		if(rng < (50 + (agility * 3))) {
			position = "Run";
			mainText.setText("You have successfully ran away.");
		}
		else {
			position = "attack";
			mainText.setText("You have failed to run away. \nLevel up agility to increase your chances of escaping");
		}
		continueButton();
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
		mainText.setText("You are dead! \n\n\n <GAME OVER>");
		choiceButtonPanel.setVisible(false);
	}
	
	public void win() {
		mainText.setText("Congratulations, you have defeated the Demon Lord \n\n\n <YOU WIN>");
		choiceButtonPanel.setVisible(false);
	}
	
	public void monsterKilled() {
		position = "monsterKilled";
		killed = true;
		if(monster.equals("Demon Lord")) {
			win = true; 
		}
		playerXP = playerXP + xpGained;
		xpLabelNumber.setText("" + playerXP + "/" + XpNeeded);
		coins = coins + coinsGained;
		coinLabelNumber.setText("" + coins);
		mainText.setText(monster + " HP: " + monsterHP + "\nCongratulations, you have killed the " + monster + ". You gained " + coinsGained + " coins and " + xpGained + " XP");
		continueButton();
	}
	
	public void locationMarker() {
		if(locationMarker.equals("forest")) {
			forestContinue();
		}
		else if(killed) {
			questComplete();
		}
		else {
			locationDecision();
		}
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
			locationMarker();
		}
	}
	
	public void Categories() {
		switch(category) {
		case "strength": categoryLvl = strength; break;
		case "defense": categoryLvl = defense; break;
		case "magic": categoryLvl = magic; break;
		case "agility": categoryLvl = agility; break;
		}
		if(categoryLvl < 10) {
			position = "categories";
			y = 0;
			switch(category) {
			case "strength": strength++; continueButton(); break;
			case "defense": defense++; maxHP = 20 + defense; continueButton(); break;
			case "magic": 
				if(magicAffinity == 1) {
					magic++; maxMana = 20 + magic; continueButton();
					}
				else {
					mainText.setText("You do not have an affinity for magic. Please choose a different category to level up. \nStrength: " + strength + "              Defense: " + defense + "\nMagic: " + magic + "                 Agility: " + agility);
					position = "lvlUp"; y = 1;
				} 
				break;
			case "agility": agility++; continueButton(); break;
			}
			if(y!=1) {
				mainText.setText("Congratulations!  You leveled up " + category);
			}
		}
		else {
			mainText.setText("You have already maxed out your " + category + ". Please choose a different category to level up. \nStrength: " + strength + "              Defense: " + defense + "\nMagic: " + magic + "                 Agility: " + agility);
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
				case "c1": lvlRequired = 5; i=0; quest(); break;
				case "c2": lvlRequired = 8; i=1; quest(); break;
				case "c3": locationDecision(); break;
				case "c4": adventurersGuild2(); break;
				}
				break;
			case "adventurersGuild2":
				switch (Choice) {
				case "c1": lvlRequired = 10; i=2; quest(); break;
				case "c2": lvlRequired = 15; i=3; quest(); break;
				case "c3": lvlRequired = 25; i=4; quest(); break;
				case "c4": locationDecision(); break;
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
				case "c1": item = "Sword"; coinsNeeded = 10; Items(); break;
				case "c2": item = "Bow"; coinsNeeded = 10; Items(); break;
				case "c3": item = "Potion"; coinsNeeded = 2; Items(); break;
				case "c4": locationDecision(); break;
				}
				break;
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
					locationMarker(); break;
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
			case "attack":
				switch(Choice) {
				case "c1": 
						monsterAttack(); break;
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
					locationMarker(); break;
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
					case "c1": magicNumber = 1; magicAttack(); break;
					case "c2": magicNumber = 2; magicAttack(); break;
					case "c3": magicNumber = 3; magicAttack(); break;
					case "c4": magicNumber = 4; magicAttack(); break;
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
					if(rng == 0 && playerXP >= XpNeeded) {
						lvlUp();
					}
					else if(rng == 2) {
						questComplete();
					}
					else {
						forestContinue();
					}
				break;
				}
				break;
			case "lvlUp":
				switch(Choice) {
				case "c1": category = "strength"; Categories();  break;
				case "c2": category = "defense"; Categories();  break;
				case "c3": category = "magic"; Categories();  break;
				case "c4": category = "agility"; Categories();  break;
				}
				break;
			case "categories":
				switch(Choice) {
				case "c1":
					if(playerXP >= XpNeeded) {
						lvlUp();
					}
					else {
						locationMarker();
					}
					break;
				}
				break;
			}
		}
	}
}
