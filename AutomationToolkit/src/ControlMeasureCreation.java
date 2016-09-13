import org.junit.*;
import org.sikuli.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

@SuppressWarnings("serial")
public class ControlMeasureCreation {
	
	Toolkit t = new Toolkit();

	@Before
	public void setUp() {

	}

	public void getCoordinates(String coor) {
		Screen s = new Screen();
		Pattern p;
		
		p = new Pattern("images/CMCreation/add.png");
		try {
			s.find(p.similar(0.95f));
		} catch (FindFailed e) {
			t.lblPassFail.setText("Fail");
		}
		

	}

	@After
	public void tearDown() {

		System.exit(0);

	}

}
