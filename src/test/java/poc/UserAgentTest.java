package poc;

import net.sf.uadetector.service.UADetectorServiceFactory;
import net.sf.uadetector.*;

import ua_parser.*;

import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAgentTest {
 
	private static final Logger logger = LoggerFactory.getLogger(UserAgentTest.class);

	private static String UA_STRING = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36";


	@Test
	@Ignore
	public void testUaDetector() throws Exception {

		uaDetector(UA_STRING);
		//uaDetector("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		uaDetector("Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3");
		uaDetector("Mozilla/5.0 (Linux; Android 6.0.1; MI 5s Build/MXB48T; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36 Line/7.3.0");
	}

	private void uaDetector(String ua) throws Exception {

		// Get an UserAgentStringParser and analyze the requesting client
		UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
		ReadableUserAgent agent = parser.parse(ua);
 
		logger.debug("{}", ua);
		logger.debug("{}", agent.getDeviceCategory());
		logger.debug("{}", agent.getFamily());
		logger.debug("{}", agent.getIcon());
		logger.debug("{}", agent.getOperatingSystem());
		logger.debug("{}", agent.getProducer());
		logger.debug("{}", agent.getProducerUrl());
		logger.debug("{}", agent.getType());
		logger.debug("{}", agent.getTypeName());
		logger.debug("{}", agent.getUrl());
		logger.debug("{}", agent.getVersionNumber());
		logger.debug("{}\n", agent.getOperatingSystem().getName());
	}

	@Test
	public void testUaParser() throws Exception {

		parseUa(UA_STRING);
		//parseUa("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		parseUa("Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3");
		parseUa("Mozilla/5.0 (Linux; Android 6.0.1; MI 5s Build/MXB48T; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36 Line/7.3.0");
	}

	private void parseUa(String ua) throws Exception {

		Parser uaParser = new Parser();
		Client c = uaParser.parse(ua);

		logger.debug("UA: {}", ua);
		logger.debug("Device    : {}", c.device.family);    // => "iPhone"

		logger.debug("UA family : {}", c.userAgent.family); // => "Mobile Safari"
		logger.debug("UA major  : {}", c.userAgent.major);  // => "5"
		logger.debug("UA minor  : {}", c.userAgent.minor);  // => "1"

		logger.debug("OS family : {}", c.os.family);        // => "iOS"
		logger.debug("OS major  : {}", c.os.major);         // => "5"
		logger.debug("OS minor  : {}\n", c.os.minor);        // => "1"


	}
}