import {Box, Button} from "@mui/material";
import {copyCoreConfig, replaceLineCoreConfig} from "./api/CoreConfigAPIs";

const Homepage = () => {

    return(
        <>
            <Box>
                WELCOME TO THE TAK EDITOR
            </Box>
            <Button onClick={() => copyCoreConfig()}> Copy Core Config</Button>
            <Button onClick={() => replaceLineCoreConfig()}> Delete Line From Core Config</Button>

        </>
    );
}
export default Homepage;
