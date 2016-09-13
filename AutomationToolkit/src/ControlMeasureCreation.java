import org.junit.Before;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.junit.After;

public class ControlMeasureCreation {

	Toolkit t = new Toolkit();

	@Before
	public void setUp() {

	}

	public void getCoordinates(String coor) {
		
		final Thread t1 = new Thread(new Runnable() {
		     public void run() {
		          // code goes here.
		     
		

		Screen s = new Screen();
		

		Pattern p;

		try {

			p = new Pattern("images/CMCreation/add.png");
			s.find(p.similar(0.95f));
			s.click(p.similar(0.90f));// click add

			p = new Pattern("images/CMCreation/add.png");
			t.lblPassFail.setText("Pass");

		} catch (FindFailed e) {
			t.lblPassFail.setText("Fail");
		}
		
		     }
		}); 
		t1.start();

	}

	@After
	public void tearDown() {

		System.exit(0);

	}

}
