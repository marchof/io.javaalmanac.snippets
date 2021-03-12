package io.javaalmanac.snippets.time;

import org.junit.jupiter.api.Test;

import io.javaalmanac.snippets.ConsoleGrabber;

public class Friday13thTest {

	@Test
	void run_main() throws Exception {
		ConsoleGrabber.assertOutEquals(Friday13th::main, """
				Fri 2000-10-13
				Fri 2001-04-13
				Fri 2001-07-13
				Fri 2002-09-13
				Fri 2002-12-13
				Fri 2003-06-13
				Fri 2004-02-13
				Fri 2004-08-13
				Fri 2005-05-13
				Fri 2006-01-13
				Fri 2006-10-13
				Fri 2007-04-13
				Fri 2007-07-13
				Fri 2008-06-13
				Fri 2009-02-13
				Fri 2009-03-13
				Fri 2009-11-13
				Fri 2010-08-13
				Fri 2011-05-13
				Fri 2012-01-13
				Fri 2012-04-13
				Fri 2012-07-13
				Fri 2013-09-13
				Fri 2013-12-13
				Fri 2014-06-13
				Fri 2015-02-13
				Fri 2015-03-13
				Fri 2015-11-13
				Fri 2016-05-13
				Fri 2017-01-13
				Fri 2017-10-13
				Fri 2018-04-13
				Fri 2018-07-13
				Fri 2019-09-13
				Fri 2019-12-13
				Fri 2020-03-13
				Fri 2020-11-13
				Fri 2021-08-13
				Fri 2022-05-13
				Fri 2023-01-13
				Fri 2023-10-13
				Fri 2024-09-13
				""");
	}

}
