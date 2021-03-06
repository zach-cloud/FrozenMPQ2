package stepDefs;

import frost.FrostMpq;
import interfaces.IFrostMpq;
import io.FileWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.mockito.Mockito;
import settings.MpqContext;
import settings.MpqSettings;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.Set;

import static org.mockito.Matchers.any;

public class MpqStepDefs {

    private File resourcesRoot = new File("src/test/resources/");
    private File mpqFile;
    private IFrostMpq mpq;
    private MpqContext context;
    private FileWriter mockFileWriter;
    private Set<String> fileNames;

    @Given("MPQ file: {string}")
    public void mpq_file(String fileName) {
        String filePath = resourcesRoot.getAbsolutePath() + "\\" + fileName;
        mpqFile = new File(filePath);
    }

    @When("MPQ file is read")
    public void mpq_file_is_read() {
        this.context = new MpqContext();
        this.context.setSettings(new MpqSettings(MpqSettings.LogSettings.NONE,
                MpqSettings.MpqOpenSettings.ANY));
        this.mpq = new FrostMpq(mpqFile, context);
    }

    private void makeMockFileWriter() {
        this.mockFileWriter = Mockito.mock(FileWriter.class);
        this.context.setFileWriter(mockFileWriter);
    }

    @When("File is extracted: {string}")
    public void file_is_extracted(String fileName) {
        try {
            makeMockFileWriter();
            mpq.extractFile(fileName);
        } catch (Exception ex) {
        }
    }

    @When("All known files are extracted")
    public void all_known_files_are_extracted() {
        makeMockFileWriter();
        mpq.extractAllKnown();
    }

    @When("All known files are extracted with listfile {string}")
    public void all_known_files_are_extracted_with_listfile(String listfilePath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(listfilePath);
        File listfile = new File(url.getPath());
        makeMockFileWriter();
        mpq.extractAllKnown(listfile);
    }

    @When("File names are retrieved")
    public void file_names_are_retrieved() {
        this.fileNames = mpq.getFileNames();
    }

    @Then("MPQ should have {int} total files")
    public void mpq_should_have_total_files(int count) {
        Assert.assertEquals(count, mpq.getFileCount());
    }

    @Then("MPQ should have {int} known files")
    public void mpq_should_have_known_files(int count) {
        Assert.assertEquals(count, mpq.getKnownFileCount());
    }

    @Then("MPQ should have {int} unknown files")
    public void mpq_should_have_unknown_files(int count) {
        Assert.assertEquals(count, mpq.getUnknownFileCount());
    }

    @Then("File should exist: {string}")
    public void file_should_exist(String fileName) {
        Assert.assertTrue(mpq.fileExists(fileName));
    }

    @Then("File should have been extracted: {string}")
    public void file_should_have_been_extracted(String fileName) throws Exception {
        Mockito.verify(mockFileWriter, Mockito.times(1)).write(any(), any());

    }

    @Then("{int} files should have been extracted")
    public void files_should_have_been_extracted(int count) throws Exception {
        Mockito.verify(mockFileWriter, Mockito.times(count)).write(any(), any());
    }

    @Then("There should be {int} file names")
    public void there_should_be_file_names(int count) {
        Assert.assertEquals(count, fileNames.size());
    }

    @Given("File is deleted: {string}")
    public void file_is_deleted(String fileName) {
        String filePath = resourcesRoot.getAbsolutePath() + "\\" + fileName;
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
        }
    }

    @When("File is added {string}")
    public void file_is_added(String fileName) throws Exception {
        String filePath = resourcesRoot.getAbsolutePath() + "\\" + fileName;
        File file = new File(filePath);
        if(file.exists()) {
            byte[] data = IOUtils.toByteArray(new FileInputStream(file));
            mpq.importFile(fileName, data);
        } else {
            Assert.fail("No file provided");
        }
    }
    @When("File is saved as {string}")
    public void file_is_saved_as(String fileName) {
        String filePath = resourcesRoot.getAbsolutePath() + "\\" + fileName;
        mpq.save(new File(filePath));
    }

    @Given("a real file writer")
    public void a_real_file_writer() {
        this.context.setFileWriter(new FileWriter());
    }

    @Then("File should exist on disk {string}")
    public void file_should_exist_on_disk(String fileName) {
        String filePath = resourcesRoot.getAbsolutePath() + "\\" + fileName;
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
    }
}
