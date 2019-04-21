/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 19:14:16 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 19:17:03
 */
package me.cmilby.chessbackend.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.binary.Base64;

/**
 * RandomUtil
 */
public class RandomUtil {

	public static String randomBase64 ( ) {
		Random random = ThreadLocalRandom.current ( );
		byte [ ] r = new byte [ 16 ];
		random.nextBytes ( r );
		return Base64.encodeBase64String ( r );
	}
}