class Config26 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.mac',
                additionalTestLabels: '!sw.os.osx.10_15',
                test                : 'default',
                configureArgs       : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs           : '--create-jre-image --ssh',
                cleanWorkspaceAfterBuild: true,
                test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.openjdk",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.jck",
                        "extended.openjdk",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.openjdk",
                        "special.system",
                        "dev.functional",
                        "dev.openjdk"
                    ]
                        ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile          : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode          : 'sw.tool.docker',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs           : '--create-jre-image --ssh',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)',
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'EBC:os=windows,arch=x86-64,distro=windows2025',
                cleanWorkspaceAfterBuild: true,
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [     
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
            ],
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: 'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.17_1',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs           : '--create-jre-image --ssh',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2TL5'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.s390x',
                dockerImage: 'runtimes/ibm-java-8/s390x-redhat7:gcc14_semeru',
                dockerRegistry: 'https://icr.io/',
                dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
                dockerNode : 'sw.tool.docker',
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                configureArgs : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac',
                ],
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                crossCompile        : 'qemustatic',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:ubuntu2004_linux-riscv64',
                dockerArgs          : '--platform linux/riscv64',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes --enable-dtrace',
                buildArgs           : [
                        ]
        ]
  ]

}

Config26 config = new Config26()
return config.buildConfigurations