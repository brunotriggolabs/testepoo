/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author samuel
 */
public class teste {

    private static final Logger logger = Logger.getLogger(teste.class);

    public static void main(String argv[]) {
        BasicConfigurator.configure();
        logger.debug("Hello world.");
        logger.info("What a beatiful day.");
    }
}
