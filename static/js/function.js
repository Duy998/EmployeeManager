// Custom function.

function getFeatures(scopeFeatures) {
    let features = scopeFeatures.map(key => {
        let keys = [];
        if (key.match(/add/g) !== null) {
            keys.push(key)
        }
        return keys;
    });
    features = [].concat(...features);
    return features;
}

// Current Navigation Event
function currNavEvent(event) {
    let features = getFeatures(Object.keys(this.$parent));

    // return false into all feature
    features.forEach(feature => this[feature] = false);
    console.log(features);
    let name = "add" + event[0].toUpperCase() + event.slice(1, event.length);
    this[name] = true;
    console.log(this[name]);
}

function currentNavEvent(event) {
    switch (event) {
        case "employee":
            this.addEmployee = true;
            this.addTeam = false;
            this.addPosition = false;
            break;
        case "team":
            this.addEmployee = false;
            this.addTeam = true;
            this.addPosition = false;
            break;
        case "position":
            this.addEmployee = false;
            this.addTeam = false;
            this.addPosition = true;
            break;
    }
}

function checkAllScope() {
    let checkboxs = document.getElementsByName("name[]");
    for (let i = 0; i < checkboxs.length; i++) {
        checkboxs[i].checked = !checkboxs[i].checked;
    }
}

function changeViewEvent(event) {
    this.viewTeam = event;
    if (event != "file/team/listteam.html") {
        this.nameDefault = "Detail team";
        this.hideShow = true;
    } else {
        this.nameDefault = "List team";
        this.hideShow = false;
    }
}

function choseTeam(event) {
    this.viewTeam = "file/team/inforteam.html";
    if (this.viewTeam != "file/team/inforteam.html") {
        this.hideShow = true;
    } else {
        this.hideShow = false;
    }
}

function openModalEvent() {
    let _width = window.screen.width;
    if (_width > 580) {
        $('.navbars').css({
            'width': '45%',
            'transition': '.5s'
        });
    } else {
        $('.navbars').css({
            'width': '75%',
            'transition': '.5s'
        });
    }
}

function closeModalEvent() {
    $('.navbars').css({
        'width': '0%',
        'transition': '.5s'
    });
}