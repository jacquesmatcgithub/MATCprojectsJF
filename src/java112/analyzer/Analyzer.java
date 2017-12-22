package java112.analyzer;
import java.io.*;
import java.util.*;

/**
  * The Analyzer interface is used by the Analyzer objects to either
  * process a single token, or to write an output file depending on
  * which method is used.
  *
  * @author Jacques Fourie
  * interface Analyzer
  */
public interface Analyzer {


    /**
      * The intent of the processToken method is to allow the
      * implementing class to process a single token.
      * @param token A single token passed to the method
      */
    void processToken(String token);


    /**
      * The intent of the writeOutputFile method is to allow the
      * implementing class to write an output file.
      * @param inputFilePath File path of the file to be read.
      */
    void writeOutputFile(String inputFilePath);
}