// const host = "http://localhost:8080/"
const request = (endpoint: string, method?: string) => {
    // fetch(host + endpoint,
    fetch(endpoint,
        {
            method: method || "GET"
        }
    )
}
export const copyCoreConfig = () => {
    request("/copy");
}
export const replaceLineCoreConfig = () => {
    request("/replace");
}

// export const deleteCoreConfig = () => {
//     request("/delete", "DELETE")
// }

