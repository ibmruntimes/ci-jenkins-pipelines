targetConfigurations = [
        "x64Mac"      : [
                "openj9"
        ],
        "x64Linux"    : [
                "openj9"
        ],
        "x64Windows"  : [
                "openj9"
        ],
        "ppc64Aix"    : [
                "openj9"
        ],
        "ppc64leLinux": [
                "openj9"
        ],
        "s390xLinux"  : [
                "openj9"
        ],
        "aarch64Linux": [
                "openj9"
        ]
]

// 23:30 Mon, Wed, Fri
triggerSchedule_nightly="TZ=UTC\n30 23 * * 1,3,5"
// 04:30 Sun
triggerSchedule_weekly="TZ=UTC\n30 04 * * 7"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "hotspot"        : "",
        "openj9"         : "",
        "corretto"       : "",
        "dragonwell"     : ""
]

return this
