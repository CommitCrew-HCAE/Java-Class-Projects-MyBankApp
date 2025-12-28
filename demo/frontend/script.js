const baseUrl = "http://localhost:8080/api/accounts";

async function createAccountJS(ownerName, accountType) {
    const url = `${baseUrl}?ownerName=${encodeURIComponent(ownerName)}&accountType=${accountType}`;
    const res = await fetch(url, { method: 'POST' });
    return await res.json();
}

async function depositJS(accountNumber, amount) {
    const url = `${baseUrl}/${accountNumber}/deposit?amount=${amount}`;
    const res = await fetch(url, { method: 'POST' });
    return await res.text();
}

async function withdrawJS(accountNumber, amount) {
    const url = `${baseUrl}/${accountNumber}/withdraw?amount=${amount}`;
    const res = await fetch(url, { method: 'POST' });
    return await res.text();
}

async function getAccountInfoJS(accountNumber) {
    const url = `${baseUrl}/${accountNumber}`;
    const res = await fetch(url);
    if (res.ok) return await res.json();
    else return null;
}