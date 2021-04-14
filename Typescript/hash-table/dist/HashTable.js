"use strict";
/**
 *
 * Created by Yukiao
 *
 */
class HashTabel {
    /**
     *
     * @param size Size of the bucket
     */
    constructor(size) {
        this.size = size;
        this.hashTableArray = new Array(this.size);
        this.keylist = [];
    }
    /**
     * @description Print the elements inside the hash table array
     * @returns {void}
     */
    show() {
        console.log(this.hashTableArray);
    }
    /**
     * @param key Key to hash
     * @returns generated hash value
     * @description Generate hash value from given key using combined ASCII and Division method
     */
    hash(key) {
        try {
            // Check if type of key is string
            if (typeof key === "string") {
                let total = 0;
                let keyArray = key.split("");
                // Searching empty slot using linear probing
                for (let i = 0; i < keyArray.length; i++) {
                    total += keyArray[i].charCodeAt(0);
                }
                // Push the given key to the keylist
                this.keylist.push(key);
                return total % this.size;
            }
            else if (typeof key === "number") {
                //Chech if the given key is integer or not
                if (Number.isInteger(key)) {
                    let stringOfNumber = key.toString();
                    let total = 0;
                    let keyArray = stringOfNumber.split("");
                    // Search for the empty slot using linear probing
                    for (let i = 0; i < keyArray.length; i++) {
                        total += keyArray[i].charCodeAt(0);
                    }
                    //push the given key to the keylist
                    this.keylist.push(key);
                    return total % this.size;
                }
                else {
                    // Throwing error when the given key is not string or integer
                    throw new Error("Key must be integer or string");
                }
            }
            else {
                // Throwing error when the given key is not string or integer
                throw new Error("Key must be integer or string");
            }
        }
        catch (e) {
            console.error(e.message);
            process.exit();
        }
    }
    /**
     *
     * @param key Key to be hashed
     * @returns Generated hash value
     * @description Hash method that is using in insert
     */
    hashToInsert(key) {
        if (this.keylist.includes(key)) {
            throw new Error("Key already exist");
        }
        else {
            return this.hash(key);
        }
    }
    /**
     *
     * @param key Key to be hashed
     * @returns Generated hash value
     * @description Hash method that is using in search and delete
     */
    hashToGet(key) {
        if (!this.keylist.includes(key)) {
            throw new Error("Key not exist");
        }
        else {
            return this.hash(key);
        }
    }
    /**
     * @param key Key of the item
     * @param value Item value
     * @description Insert the data item to the hash table
     */
    insert(key, value) {
        const data = new DataItem(key, value);
        const hashedKey = this.hashToInsert(key);
        if (!this.hashTableArray[hashedKey]) {
            this.hashTableArray[hashedKey] = data;
        }
        else {
            if (hashedKey === this.size - 1) {
                for (let i = 0; i < this.size; i++) {
                    if (!this.hashTableArray[i]) {
                        this.hashTableArray[i] = data;
                        return;
                    }
                    if (i === hashedKey) {
                        throw new Error("Hash Table is full");
                    }
                }
            }
            else {
                for (let i = hashedKey + 1; i < this.size; i++) {
                    if (i === hashedKey) {
                        throw new Error("Hash Table is full");
                    }
                    if (i === this.size - 1 && this.hashTableArray[i]) {
                        i = -1;
                    }
                    if (!this.hashTableArray[i]) {
                        this.hashTableArray[i] = data;
                        return;
                    }
                }
            }
        }
    }
    /**
     *
     * @param key Key of the item
     * @returns Item
     * @description Perform search to find the item using the given key
     */
    get(key) {
        try {
            const hashedKey = this.hashToGet(key);
            if (this.hashTableArray[hashedKey].key === key) {
                return this.hashTableArray[hashedKey].data;
            }
            if (hashedKey === this.size - 1) {
                for (let i = 0; i < this.size; i++) {
                    if (i === hashedKey) {
                        throw new Error("No such key");
                    }
                    if (this.hashTableArray[i].key === key) {
                        return this.hashTableArray[i].data;
                    }
                }
            }
            else {
                for (let i = hashedKey + 1; i < this.size; i++) {
                    if (i === this.size - 1 && this.hashTableArray[i].key !== key) {
                        i = -1;
                    }
                    if (this.hashTableArray[i].key === key) {
                        return this.hashTableArray[i].data;
                    }
                }
            }
            throw new Error("No such key");
        }
        catch (e) {
            console.error(e.message);
            process.exit();
        }
    }
    /**
     *
     * @param key Key of the item
     * @returns {void}
     * @description Remove item from the hash table
     */
    deleteItem(key) {
        try {
            const hashedKey = this.hashToGet(key);
            if (this.hashTableArray[hashedKey].key === key) {
                delete this.hashTableArray[hashedKey];
            }
            else {
                if (hashedKey === this.size - 1) {
                    for (let i = 0; i < this.size - 1; i++) {
                        if (this.hashTableArray[i].key === key) {
                            delete this.hashTableArray[i];
                            return;
                        }
                    }
                    throw new Error("Item not found");
                }
                else {
                    for (let i = hashedKey + 1; i < this.size; i++) {
                        if (this.hashTableArray[i].key === key) {
                            delete this.hashTableArray[i];
                            return;
                        }
                        if (i === this.size - 1 && this.hashTableArray[i].key !== key) {
                            i = -1;
                        }
                        if (i === hashedKey) {
                            throw new Error("Item not found");
                        }
                    }
                }
            }
        }
        catch (e) {
            console.error(e.message);
            process.exit();
        }
    }
}
class DataItem {
    constructor(key, value) {
        this.key = key;
        this.data = value;
    }
}
const hashTable = new HashTabel(10);
// Inserting item
hashTable.insert(1, "Testing");
hashTable.insert(12, "yoyo");
hashTable.insert(2, "Linear Probing next 2");
hashTable.insert(68, "Linear Probing next 68");
hashTable.insert(7, "Linear Probing next 7");
// Show
hashTable.show();
// Search item
console.log(`\nValue of the item with key= 68 is ${hashTable.get(68)} \n`);
// console.log(`\nValue of the item with key = 33 is ${hashTable.get(33)} \n`);
// Delete Item
hashTable.deleteItem(68);
// Show
hashTable.show();
