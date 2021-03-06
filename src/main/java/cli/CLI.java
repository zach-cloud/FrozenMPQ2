package cli;

import frost.FrostMpq;
import org.apache.commons.io.FileUtils;
import settings.GlobalSettings;
import settings.MpqSettings;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

/**
 * Command line interface for tool.
 */
public final class CLI {

    // Default listfile path
    private String LISTFILE_PATH = "listfile.txt";

    /**
     * Runs Frost MPQ Editor CLI
     */
    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Frost v " + GlobalSettings.VERSION);
        System.out.println(GlobalSettings.GITHUB_LINK);
        System.out.println("------------------");
        System.out.print("Enter filename: ");
        String inFile = scanner.nextLine();
        if (!inFile.contains(".")) {
            inFile = inFile + ".w3x";
        }
        MpqSettings settings = new MpqSettings(MpqSettings.LogSettings.DEBUG, MpqSettings.MpqOpenSettings.CRITICAL);

        FrostMpq frostMPQ = new FrostMpq(inFile, settings);
        while (true) {
            System.out.print("Enter action type (extract/list/extractAllKnown/import/delete/save/quit): ");
            String actionType = scanner.nextLine();
            executeAction(scanner, frostMPQ, actionType);
        }
    }

    /**
     * Runs the user-provided action.
     *
     * @param scanner    User input scanner
     * @param frostMPQ   MPQ Archive
     * @param actionType Action to run
     */
    private void executeAction(Scanner scanner, FrostMpq frostMPQ, String actionType) {
        if (actionType.equalsIgnoreCase("extract")) {
            extract(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("list")) {
            list(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("extractAllKnown")) {
            extractAllKnown(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("count")) {
            System.out.println("Total files: " + frostMPQ.getFileCount());
        } else if (actionType.equalsIgnoreCase("countKnown")) {
            System.out.println("Known files: " + frostMPQ.getFileCount());
        } else if (actionType.equalsIgnoreCase("save")) {
            runSave(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("import")) {
            runImport(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("delete")) {
            runDelete(scanner, frostMPQ);
        } else if (actionType.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
    }

    /**
     * Saves archive
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void runSave(Scanner scanner, FrostMpq frostMPQ) {
        System.out.print("Enter filename to save as: ");
        String fileName = scanner.nextLine();
        frostMPQ.save(new File(fileName));
        System.out.println("File saved");
    }

    /**
     * Deletes a file from archive
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void runDelete(Scanner scanner, FrostMpq frostMPQ) {
        System.out.print("Enter file to delete: ");
        String fileName = scanner.nextLine();
        if (frostMPQ.fileExists(fileName)) {
            frostMPQ.delete(fileName);
        }
    }

    /**
     * Imports a file into archive
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void runImport(Scanner scanner, FrostMpq frostMPQ) {
        try {
            File inputFile;
            do {
                System.out.print("Enter file to import: ");
                inputFile = new File(scanner.nextLine());
            } while (!inputFile.exists());
            frostMPQ.importFile(inputFile.getName(), FileUtils.readFileToByteArray(inputFile));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Extracts all known files
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void extractAllKnown(Scanner scanner, FrostMpq frostMPQ) {
        File listfilePath = getListfile(scanner);
        if (listfilePath.exists()) {
            frostMPQ.extractAllKnown(listfilePath);
        } else {
            frostMPQ.extractAllKnown();
        }
    }

    /**
     * Extracts a single file.
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void extract(Scanner scanner, FrostMpq frostMPQ) {
        System.out.print("Enter filename to extract: ");
        String fileName = scanner.nextLine();
        if (frostMPQ.fileExists(fileName)) {
            frostMPQ.extractFile(fileName);
        } else {
            System.out.println("File does not exist.");
        }
    }

    /**
     * Lists all files in archive
     *
     * @param scanner  User input scanner
     * @param frostMPQ MPQ Archive
     */
    private void list(Scanner scanner, FrostMpq frostMPQ) {
        File listfilePath = getListfile(scanner);
        if (listfilePath.exists()) {
            frostMPQ.addExternalListfile(listfilePath);
        }
        Set<String> entries = frostMPQ.getFileNames();
        System.out.println("-------");
        System.out.println("Files:");
        for (String entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-------");
    }

    /**
     * Asks the user for a listfile
     *
     * @param scanner User input scanner
     * @return Listfile that may or may not exist
     */
    private File getListfile(Scanner scanner) {
        File listfilePath = new File(LISTFILE_PATH);
        if (!listfilePath.exists()) {
            System.out.print("Enter listfile path: ");
            listfilePath = new File(scanner.nextLine());
        }
        return listfilePath;
    }
}
