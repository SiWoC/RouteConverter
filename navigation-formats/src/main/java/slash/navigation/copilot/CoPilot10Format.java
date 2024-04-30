package slash.navigation.copilot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import slash.navigation.base.ParserContext;
import slash.navigation.base.RouteCharacteristics;
import slash.navigation.base.TextNavigationFormat;
import slash.navigation.common.NavigationPosition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import static slash.common.io.Transfer.*;

public class CoPilot10Format extends TextNavigationFormat<CoPilot10Root> {

    private final ObjectMapper om = new ObjectMapper();

    public void read(InputStream source, ParserContext<CoPilot10Root> context) throws IOException {
        read(source, UTF8_ENCODING, context);
    }

    @Override
    public void read(InputStream source, String encoding, ParserContext<CoPilot10Root> context) throws IOException {
        CoPilot10Root root = om.readValue(source, CoPilot10Root.class);
        if (root.trip != null && !root.trip.stops.isEmpty()) {
            context.appendRoute(root);
        }
    }

    @Override
    public void read(BufferedReader reader, String encoding, ParserContext<CoPilot10Root> context) throws IOException {
        CoPilot10Root root = om.readValue(reader, CoPilot10Root.class);
        if (root.trip != null && !root.trip.stops.isEmpty())
            context.appendRoute(root);
    }

    @Override
    public void write(CoPilot10Root root, PrintWriter writer, int startIndex, int endIndex) throws IOException {
        om.writeValue(writer, root);
    }

    @Override
    public String getName() {
        return "CoPilot 10 (*" + getExtension() + ")";
    }

    @Override
    public String getExtension() {
        return ".trp";
    }

    @Override
    public int getMaximumPositionCount() {
        return UNLIMITED_MAXIMUM_POSITION_COUNT;
    }

    @Override
    public boolean isSupportsMultipleRoutes() {
        return false;
    }

    @Override
    public boolean isWritingRouteCharacteristics() {
        return false;
    }

    @Override
    public <P extends NavigationPosition> CoPilot10Root createRoute(RouteCharacteristics characteristics, String name, List<P> positions) {
        return new CoPilot10Root(this, characteristics, name, (List<CoPilot10Stop>) positions);
    }

}
