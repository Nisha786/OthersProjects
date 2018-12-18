package in.com.prestige.contructor;

public class TextEditor {
	private SpellChecker spellChecker;
    private String name;
	public TextEditor(SpellChecker spellChecker,String name) {
          this.spellChecker = spellChecker;
          this.name = name;
          System.out.println("This is Inside TextEditor Constructor");
	}
	public void show(){
		System.out.println(name);
		spellChecker.checkSpelling();
	}
}
